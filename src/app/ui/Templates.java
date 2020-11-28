package app.ui;

import app.util.color.Color;
import app.util.color.ColorChanger;

class Templates {

    static String  getWelcomeTemplate(){
        ColorChanger.changeColor(Color.BLUE);
        return ("\nWelcome to my weapons application, for exit enter 'exit'" +
                "\nFor executing command enter command number." +
                "\nYou can import weapons data from saved files using 'import <path>' " +
                "\nFor distance calculating we used meter" +
                "\nGood luck!!!");
    }

    static String getMainMenuTemplate(){
        ColorChanger.changeColor(Color.GREEN);
        return  "\n1. Add weapon" +
                "\n2. Print all weapons" +
                "\n3. Print all effective weapons for target" +
                "\n4. Print all upgradeable weapons" +
                "\n5. Print all suitable weapons" +
                "\n6. Individual actions with weapons data";
    }

    static String getSubMenuTemplate(){
        ColorChanger.changeColor(Color.GREEN);
        return  "\n1. Print weapon info" +
                "\n2. Print expiration date for weapon" +
                "\n3. Print full defenders count by front length and target depth" +
                "\n4. Back to main menu";
    }

    static void printWeaponTypeMenu(){
        ColorChanger.changeColor(Color.YELLOW);
        System.out.println("Choose weapon type number");
        System.out.println(
                "\n1. Howitzer" +
                "\n2. Automatic howitzer" +
                "\n3. MRL" +
                "\n4. Long range ballistic missile" +
                "\n5. Air defence system" +
                "\n6. Back to main menu");
    }
}
