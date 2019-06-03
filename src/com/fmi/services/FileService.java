package com.fmi.services;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileService {

    public static void appendLinesToFile(String path, ArrayList<String> data) {
        try {
            FileWriter out = new FileWriter(new File(path), true);

            for(String s: data) {
                out.write(s + "\n");
            }

            out.close();
        } catch (Exception ex) {
            System.out.println("appendLinesToFile failed!!!");
            System.out.println(ex.getMessage());
        }
    }

    public static void appendLineToFile(String path, String line) {
        try {
            FileWriter out = new FileWriter(new File(path), true);
            out.write(line + "\n");
            out.close();
        } catch (Exception ex) {
            System.out.println("appendLineToFile failed!!!");
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<String> readLinesFromFile(String path) {
        ArrayList<String> data = new ArrayList<>();
        try {
            Scanner in = new Scanner(new File(path));

            while(in.hasNextLine()) {
                data.add(in.nextLine());
            }

            in.close();

        } catch (Exception ex) {
            System.out.println("readLinesFromFile failed!!!");
            System.out.println(ex.getMessage());
        }
        return data;
    }

}
