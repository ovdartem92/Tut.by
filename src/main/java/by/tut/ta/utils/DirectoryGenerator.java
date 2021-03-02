package by.tut.ta.utils;

import by.tut.ta.framework.logging.Log;

import java.io.File;
import java.util.Objects;

import static java.lang.String.format;

public class DirectoryGenerator {

    private DirectoryGenerator() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", DirectoryGenerator.class));
    }

    public static String create(String pathToDirectory) {
        Objects.requireNonNull(pathToDirectory, "Path to directory cannot be null.");
        File folder = new File(pathToDirectory);
        boolean successFlag = folder.mkdirs();
        if (!successFlag) {
            Log.warn("Failed to create dirs using the following path: " + pathToDirectory);
        }
        return folder.getAbsolutePath();
    }
}
