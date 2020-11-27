package app.util;

import app.model.base.AbstractHeavyLongRangeWeapon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class WeaponsDataWriter {

    public static void saveWeapon(AbstractHeavyLongRangeWeapon weapon) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to save weapons data");
        String path = scanner.nextLine();
        try {

            File file = new File(path);
            if (!file.exists()) {
                if (!file.createNewFile())
                    System.err.println("Something is wrong");
            }

            WeaponsCache.add(weapon);

            if (!file.canWrite()) file.setWritable(true);
            Files.writeString(Paths.get(file.toURI()), weapon.toString() + "\n", StandardOpenOption.APPEND);
            file.setWritable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
