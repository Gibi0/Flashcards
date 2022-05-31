package com.company;

import jdk.jfr.Timestamp;
import org.bson.BsonDateTime;
import org.bson.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        RandomWords r = new RandomWords();
//        LocalDateTime date = LocalDateTime.now();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Database dataBase = new Database();
//        System.out.println(dtf.format(date));
//        System.out.println(dataBase.getCollection().countDocuments());
//        Document update = new Document();
            r.getWords();
//        update.append("$set", new Document().append("English_Word", "tu jest englisz słowo"));
//        dataBase.getCollection().updateMany(new Document().append("English_Word","siema"), update);
//        dataBase.getCollection().find().forEach(System.out::println);
//        dataBase.getCollection().find(new Document("_id", 4)).forEach(System.out::println);
    }
}
