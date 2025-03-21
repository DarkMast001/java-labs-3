package org.example.task_10_11;

import java.io.File;

public class DirectoryLister {
    public static File[] getSubdirectories(File directory) {
        if (directory == null || !directory.isDirectory()) {
            throw new IllegalArgumentException("Указанный файл не является каталогом.");
        }

        return directory.listFiles(file -> file.isDirectory());

//        return directory.listFiles(File::isDirectory);

//        return directory.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File file) {
//                return file.isDirectory();
//            }
//        });
    }

    public static String[] getFilesWithExtension(File directory, String extension) {
        if (directory == null || !directory.isDirectory()) {
            throw new IllegalArgumentException("Указанный файл не является каталогом.");
        }

        return directory.list((dir, name) -> name.endsWith("." + extension));
    }
}
