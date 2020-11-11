package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Класс, отвечающий за непосредственное соединение передаваемые файлов в один файл
 */
public class ConcatenatorTxtFiles {
    public static void concatenate(ArrayList<File> files) throws IOException {
        Date date = new Date();
        File result = new File("src/results/result" + date + ".txt");
        if(!result.exists()) {
            if (!result.createNewFile()) {
                System.out.println("error");
            }
        }
        FileWriter writer = new FileWriter(result, true);

            for(var file:files){
                if(file.getPath().contains("$")) continue;
                System.out.println(file.getPath());
                FileReader reader = new FileReader(file);
                while (reader.ready()){
                    int read = reader.read();
                    writer.append((char)read);
                }
                reader.close();
        }
            writer.close();
    }
}
