package com.htec.codingexercise.ui.fragment.list.utils;

import java.io.InputStream;

/**
 * Wraps around {@link FileUtils} class and provides InputStream directly.
 */
public class FileUtils {
    public static InputStream getFileResource(String resource) {
        return FileUtils.class.getClassLoader().getResourceAsStream(resource);
    }
}
