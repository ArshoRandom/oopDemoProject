package app.ui;

class Templates {

    static String  getWelcomeTemplate(){
        return ("Welcome to my weapons application, for exit enter 'exit',\nFor changing menu color enter 'color <color number>'" +
                "(red:1 , yellow:2, sun-yellow:3, blue:4, purple:5, cyan:6, white:7), example 'color 1'\nFor executing command enter command number. Good luck!!!");
    }

    static String getMainMenuTemplate(){

        return  "\n1. Add weapon\n" +
                "2. Print all weapons\n" +
                "3. Print all effective weapons for target\n" +
                "4. Print all upgradeable weapons\n" +
                "5. Print all not suitable weapons\n" +
                "6. Individual actions with weapons data";
    }

    static String getSubMenuTemplate(){

        return  "\n1. Print weapon info\n" +
                "2. Print expiration date for weapon\n" +
                "3. Print full defenders count by front length and target depth\n" +
                "4. Back to main menu";
    }

    static void printWeaponTypeMenu(){
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
