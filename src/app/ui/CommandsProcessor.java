package app.ui;

import app.base.AbstractHeavyLongRangeWeapon;
import app.exceptions.ErrorMessage;
import app.service.WeaponsService;
import app.util.WeaponsCreator;
import app.util.WeaponsDataReader;
import app.util.WeaponsDataWriter;
import app.util.WeaponsMapper;

import java.io.IOException;
import java.util.Scanner;

public class CommandsProcessor {


    private static AbstractHeavyLongRangeWeapon[] weapons;
    private static Scanner scanner;

    static {
        try {
            weapons = WeaponsMapper.map(WeaponsDataReader.readLines());
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner = new Scanner(System.in);
    }

    public static void processMainCommands(String command) throws IOException {
        command = command.trim();
        if (!command.equals("1") && weapons.length == 0){
            System.err.println("At first create weapons");
            return;
        }

        if (command.matches("[0-9]")) {
            int commandNumber = Integer.parseInt(command);
            switch (commandNumber) {
                case 1:
                    Templates.printWeaponTypeMenu();

                    int typeNumber = scanner.nextInt();
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
                            ErrorMessage.printInvalidCommandErrorMessage(typeNumber);
                    }
                    break;
                case 2:
                    for (AbstractHeavyLongRangeWeapon weapon : weapons) {
                        WeaponsService.printCharacteristics(weapon);
                    }
                    break;
                case 3:
                    System.out.println("Enter distance for calculating");
                    double distance = scanner.nextDouble();
                    for (AbstractHeavyLongRangeWeapon weapon: weapons){
                        if (weapon.isEffective(distance)){
                            WeaponsService.printCharacteristics(weapon);
                        }
                    }
                    break;
                case 4:
                    for (AbstractHeavyLongRangeWeapon weapon: weapons){
                       if (weapon.isSubjectOfUpdate()){
                           WeaponsService.printCharacteristics(weapon);
                       }
                    }
                    break;
                case 5:
                    for (AbstractHeavyLongRangeWeapon weapon: weapons){
                        if (!weapon.notSuitable()){
                            WeaponsService.printCharacteristics(weapon);
                        }
                    }
                    break;
                default:
                    ErrorMessage.printInvalidCommandErrorMessage(commandNumber);
            }
        } else {
            ErrorMessage.printInvalidCommandErrorMessage(command);
        }
    }

    public static void processSubCommands(String command) {
        command = command.trim();
        if (command.matches("[0-9]")) {
            int commandNumber = Integer.parseInt(command);
            String model;
            AbstractHeavyLongRangeWeapon weapon;
            switch (commandNumber) {
                case 1:
                    System.out.println("Enter model name");
                    model = scanner.nextLine();
                     weapon = WeaponsService.searchWeapon(weapons, model);
                    if (weapon != null)
                        WeaponsService.printCharacteristics(weapon);
                    break;
                case 2:
                    System.out.println("Enter model name");
                    model = scanner.nextLine();
                    weapon = WeaponsService.searchWeapon(weapons, model);
                    if (weapon != null)
                        System.out.println(WeaponsService.getExpirationDate(weapon));
                    break;
                case 3:
                    System.out.println("Enter model name");
                    model = scanner.nextLine();
                    weapon = WeaponsService.searchWeapon(weapons, model);

                    if (weapon != null) {
                        System.out.println("Enter front length");
                        double frontLength = scanner.nextDouble();
                        System.out.println("Enter target depth");
                        double targetDepth = scanner.nextDouble();
                        System.out.println("Count of defenders : " + WeaponsService.getCountOfDefenders(weapon,frontLength,targetDepth));
                    }
                    break;
                default:
                    ErrorMessage.printInvalidCommandErrorMessage(commandNumber);
            }
        } else {
            ErrorMessage.printInvalidCommandErrorMessage(command);
        }
    }
}
