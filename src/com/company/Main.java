package com.company;

import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Enter directory name:");
        Scanner scanner = new Scanner(System.in);
        String dirName = scanner.nextLine();
        var files = SearchTxtFiles.search(dirName);
        files = Sort.sortTxtFilesByName(files);
        ConcatenatorTxtFiles.concatenate(files);


    }
}


