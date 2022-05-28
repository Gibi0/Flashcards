package com.company;


import org.bson.Document;

import java.io.*;
//import java.util.ArrayList
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
//        Window window = new Window();
//        dataBase.getCollection().find().forEach(System.out::println);
        int i = 1;
        Database dataBase = new Database();
        String first, second;
        File file = new File("data.txt");
        Scanner s = new Scanner(file);
        s.useDelimiter("[-\n]");
        while (s.hasNext()) {
            first = s.next();
            second = s.next();
            Document doc = new Document("_id", i).append("English_Word", first).append("Polish_Word", second);
            dataBase.getCollection().insertOne(doc);
            i += 1;
        }
    }
}
