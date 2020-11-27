package app.ui;

import app.exceptions.InvalidCommandException;
import app.exceptions.ModelNotFoundException;
import app.model.base.AbstractHeavyLongRangeWeapon;
import app.service.WeaponsService;
import app.util.WeaponsCache;
import app.util.WeaponsCreator;
import app.util.WeaponsDataWriter;

import java.util.Scanner;

public class CommandsProcessor {

    private static Scanner scanner = new Scanner(System.in);


    public static void processMainCommands(String command) throws InvalidCommandException, NumberFormatException {

        if (!command.matches("[0-9]")) {
            throw new InvalidCommandException(command);
        }
        int commandNumber = Integer.parseInt(command);

        if (!(commandNumber > 0 && commandNumber < 7)) {
            throw new InvalidCommandException(command);
        }
        if (WeaponsCache.getAllCache().length == 0 && commandNumber != 1) {
            System.err.println("At first create weapons");
            return;
        }

        switch (commandNumber) {
            case 1:
                Templates.printWeaponTypeMenu();
                int typeNumber = Integer.parseInt(scanner.nextLine());
                processWeaponsCreation(typeNumber);
                break;
            case 2:
                WeaponsService.printAllWeapons(WeaponsCache.getAllCache());
                break;
            case 3:
                System.out.println("Enter distance for calculating");
                double distance = scanner.nextDouble();
                WeaponsService.printAllEffectiveWeaponsFor(distance, WeaponsCache.getAllCache());
                break;
            case 4:
                WeaponsService.printAllUpgradableWeapons(WeaponsCache.getAllCache());
                break;
            case 5:
                WeaponsService.printAllSuitableWeapons(WeaponsCache.getAllCache());
                break;
            default:
                throw new InvalidCommandException(command);
        }

    }

    private static void processWeaponsCreation(int typeNumber) throws InvalidCommandException {
        try {
            switch (typeNumber) {
                case 1:
                    WeaponsDataWriter.saveWeapon(WeaponsCreator.createHowitzer());
                    break;
                case 2:
                    WeaponsDataWriter.saveWeapon(WeaponsCreator.createAutomaticHowitzer());
                    break;
                case 3:
                    WeaponsDataWriter.saveWeapon(WeaponsCreator.createMRL());
                    break;
                case 4:
                    WeaponsDataWriter.saveWeapon(WeaponsCreator.createLongRangeBallisticMissile());
                    break;
                case 5:
                    WeaponsDataWriter.saveWeapon(WeaponsCreator.createAirDefenceSystem());
                    break;
                case 6:
                    return;
                default:
                    throw new InvalidCommandException(String.valueOf(typeNumber));

            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }


    public static void processSubCommands(String command) throws InvalidCommandException, NumberFormatException {
        int commandNumber = Integer.parseInt(command.trim());
        if (!(commandNumber > 0 && commandNumber < 4)) {
            throw new InvalidCommandException(String.valueOf(commandNumber));
        }
        String model;
        AbstractHeavyLongRangeWeapon weapon;
        try {
            switch (commandNumber) {
                case 1:
                    System.out.println("Enter model name");
                    model = scanner.nextLine();
                    weapon = WeaponsService.searchWeapon(WeaponsCache.getAllCache(), model);
                    WeaponsService.printCharacteristics(weapon);
                    break;
                case 2:
                    System.out.println("Enter model name");
                    model = scanner.nextLine();
                    weapon = WeaponsService.searchWeapon(WeaponsCache.getAllCache(), model);
                    System.out.print("\u001B[35m");
                    System.out.println(WeaponsService.getExpirationDate(weapon));
                    break;
                case 3:
                    System.out.println("Enter model name");
                    model = scanner.nextLine();
                    weapon = WeaponsService.searchWeapon(WeaponsCache.getAllCache(), model);
                    System.out.println("Enter front length (front length must be less than 1.000.000.000)");
                    double frontLength = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter target depth");
                    double targetDepth = Double.parseDouble(scanner.nextLine());
                    System.out.print("\u001B[35m");
                    System.out.println("Count of defenders : " + WeaponsService.getCountOfDefenders(weapon, frontLength, targetDepth));
                    break;
                default:
                    throw new InvalidCommandException(command);
            }
        } catch (ModelNotFoundException e) {
            e.printStackTrace();
        }

    }
}
