package app.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WeaponsDataReader {

    public static String[] readLines(String strPath) throws IOException {
        Path path = Paths.get(strPath);
        return Files.readString(path).split("\n");
    }

}
