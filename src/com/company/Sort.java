package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Класс, отвечающий за сортировку массива файлов по именам (с помощью Stream API)
 */
public class Sort {
    public static ArrayList sortTxtFilesByName(ArrayList<File> files){
        return new ArrayList<>(files.stream().sorted( new FileComparator()).collect(Collectors.toList()));
    }

}

/**
 * Реализация интерфейса нам необходима для более конкретной сортировки файлов, нежели встренная
 */
class FileComparator implements Comparator<File> {

    public int compare(File f1, File f2) {
        return f1.getName().toUpperCase().compareTo(f2.getName().toUpperCase());
    }
}