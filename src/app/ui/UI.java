package app.ui;

import app.exceptions.ErrorMessage;

import java.io.IOException;
import java.util.Scanner;

public class UI {


    private static void changeUIColorTo(String colorNumber){
        colorNumber = colorNumber.trim();
        if (colorNumber.matches("[1-7]")){
            System.out.print("\u001B[3"+colorNumber+"m");
        }else {
            ErrorMessage.printInvalidCommandErrorMessage(colorNumber);
        }
    }

    public static void start() throws IOException {
        System.out.println(Templates.getWelcomeTemplate());

        Scanner scanner = new Scanner(System.in);

        boolean inAction = true;
        boolean turnOnSecondaryMenu = false;

        String menuTemplate = Templates.getMainMenuTemplate();

        outer:
        while (inAction) {

            System.out.println(menuTemplate);
            String command = scanner.nextLine();

            if (command.startsWith("color")){
                changeUIColorTo(command.split(" ")[1]);
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
                    }
                    continue outer;
            }

            if (!turnOnSecondaryMenu) {
                CommandsProcessor.processMainCommands(command);
            } else {
                CommandsProcessor.processSubCommands(command);
            }

        }
    }
}
