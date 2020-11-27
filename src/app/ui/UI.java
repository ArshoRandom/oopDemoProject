package app.ui;

import app.exceptions.InvalidCommandException;
import app.exceptions.InvalidDataFormatException;
import app.model.base.AbstractHeavyLongRangeWeapon;
import app.util.WeaponsCache;
import app.util.WeaponsDataReader;
import app.util.WeaponsMapper;

import java.io.IOException;
import java.util.Scanner;

public class UI {


    public static void start() {
        System.out.println(Templates.getWelcomeTemplate());

        Scanner scanner = new Scanner(System.in);

        boolean inAction = true;
        boolean turnOnSecondaryMenu = false;

        String menuTemplate = Templates.getMainMenuTemplate();

        outer:
        while (inAction) {

            System.out.println(menuTemplate);
            String command = scanner.nextLine();

            if (command.matches("import (?![ ]).+")) {
                String path = command.split(" ")[1];
                try {
                    AbstractHeavyLongRangeWeapon[] weapons = WeaponsMapper.map(WeaponsDataReader.readLines(path));
                    for (AbstractHeavyLongRangeWeapon weapon : weapons) {
                        WeaponsCache.add(weapon);
                    }
                } catch (InvalidDataFormatException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    System.err.println("Invalid path : " + path);
                    continue;
                }
                System.out.println("Successfully imported");
                continue;
            }

            switch (command) {
                case "exit":
                    System.out.println("Bye!!!");
                    inAction = false;
                    continue outer;
                case "6":
                    menuTemplate = Templates.getSubMenuTemplate();
                    turnOnSecondaryMenu = true;
                    continue outer;
                case "4":
                    if (turnOnSecondaryMenu) {
                        menuTemplate = Templates.getMainMenuTemplate();
                        turnOnSecondaryMenu = false;
                        continue outer;
                    }

            }

            try {
                if (!turnOnSecondaryMenu) {
                    CommandsProcessor.processMainCommands(command);
                } else {
                    CommandsProcessor.processSubCommands(command);
                }
            } catch (InvalidCommandException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
