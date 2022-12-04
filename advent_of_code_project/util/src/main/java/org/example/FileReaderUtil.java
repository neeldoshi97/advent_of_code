package org.example;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class FileReaderUtil {

    public static <T> File getFileFromResource(String fileName, Class<T> className) throws URISyntaxException {

        ClassLoader classLoader = className.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }

    }

}