package app.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WeaponsDataReader {

    public static String[] readLines() throws IOException {
        Path path = Paths.get("local_weapons.txt");
        String[] raws = {};
        if (path.toFile().exists())
            raws = Files.readString(path).split("\n");
        return raws;
    }

}
