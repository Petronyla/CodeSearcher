package cz.cuni.mff.fileutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class MyFileUtils {

    private MyFileUtils() {

    }

    public static String readFileToString(final String path) throws IOException {
        return Files.readAllLines(Paths.get(path)).stream().collect(Collectors.joining(System.lineSeparator()));
    }

}
