package app.ui;

class Templates {

    static String  getWelcomeTemplate(){
        return ("\u001B[34m\nWelcome to my weapons application, for exit enter 'exit'" +
                "\nFor executing command enter command number." +
                "\nYou can import weapons data from saved files using 'import <path>' " +
                "\nFor distance calculating we used meter" +
                "\nGood luck!!!");
    }

    static String getMainMenuTemplate(){

        return  "\u001B[32m\n1. Add weapon\n" +
                "2. Print all weapons\n" +
                "3. Print all effective weapons for target\n" +
                "4. Print all upgradeable weapons\n" +
                "5. Print all suitable weapons\n" +
                "6. Individual actions with weapons data";
    }

    static String getSubMenuTemplate(){

        return  "\u001B[32m\n1. Print weapon info\n" +
                "2. Print expiration date for weapon\n" +
                "3. Print full defenders count by front length and target depth\n" +
                "4. Back to main menu";
    }

    static void printWeaponTypeMenu(){
        System.out.print("\u001B[33m");
        System.out.println("Choose weapon type number");
        System.out.println(
                "1. Howitzer\n" +
                "2. Automatic howitzer\n" +
                "3. MRL\n" +
                "4. Long range ballistic missile\n" +
                "5. Air defence system\n" +
                "6. Back to main menu");
    }
}
