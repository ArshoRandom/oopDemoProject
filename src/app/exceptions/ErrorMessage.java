package app.exceptions;

public class ErrorMessage {

    public static void printStandardErrorMessage(){
        System.err.println("Something is wrong");
    }

    public static void printInvalidCommandErrorMessage(int commandNumber){
        System.err.println("Invalid command : " + commandNumber);
    }

    public static void printInvalidCommandErrorMessage(String commandStr){
        System.err.println("Invalid command number : " + commandStr);
    }

    public static void printNotFoundErrorMessage(String model){
        System.err.println("Not found : " + model);
    }
}
