package app.util;

import app.base.AbstractHeavyLongRangeWeapon;
import app.exceptions.ErrorMessage;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class WeaponsDataWriter {

    public static void saveWeapon(AbstractHeavyLongRangeWeapon weapon) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to save weapons data");
        String path = scanner.nextLine();

        File file = new File(path);
        if (!file.exists()){
            if (!file.createNewFile())
                ErrorMessage.printStandardErrorMessage();
        }
        File local = new File("local_weapons.txt");
        if (!local.exists()) {
            if (!local.createNewFile())
                ErrorMessage.printStandardErrorMessage();
        }
        Files.writeString(Paths.get(file.toURI()),weapon.toString()+"\n", StandardOpenOption.APPEND);
        Files.writeString(Paths.get(local.toURI()),weapon.toString()+"\n", StandardOpenOption.APPEND);

    }

}
