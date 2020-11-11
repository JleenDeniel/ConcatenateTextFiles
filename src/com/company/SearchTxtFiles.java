package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Класс, отвечающий за поиск файлов
 */
public class SearchTxtFiles {
    public static ArrayList search(String path) throws FileNotFoundException {
        File file  = new File(path);
        if(!file.exists()){
            throw new FileNotFoundException("File not found!");
        }
        ArrayList<File> files = new ArrayList<>();
        search(file, files);

        return files;
    }

    /**
     * Метод, использующий рекурсию для обхода всех подиректорий и поиска текстовых файлов, переданной директории
     * @param file - параметр, отвечающий за директорию, которую мы "исследуем"
     * @param files - Массив, куда мы дозаписываем .txt - файлы
     */
    private static void search(File file, ArrayList<File> files){

        File[] temporaryFiles = file.listFiles();

        if(temporaryFiles != null){ //проверка на null потому что нет доступа к некоторым директориям и возникает NullPointerException
            for(var item: temporaryFiles){
                if(item.getPath().contains("ConcatenateTextFiles")) continue; // эта проверка нужна чтобы поток не читал файл с результатом и не писал в него же
                if(item.isFile() && item.getName().endsWith(".txt")){
                    files.add(item);
                }
                if(item.isDirectory()){
                    search(item, files);
                }
            }
        }
        else{
            System.out.println("Null pointed directory");
        }
    }
}
