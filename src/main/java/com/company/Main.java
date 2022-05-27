package com.company;


public class Main {

    public static void main(String[] args) {
        Window window = new Window();
        Database dataBase = new Database();

        dataBase.getCollection().find().forEach(System.out::println);
    }
}
