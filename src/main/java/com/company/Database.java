package com.company;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Database {
    private final MongoClient client = MongoClients.create("mongodb+srv://DefaultUser:KkNYxPq7OtNyEI6H@cluster0.jeeko.mongodb.net/?retryWrites=true&w=majority");
    private final MongoDatabase db = client.getDatabase("FlashcardsDB");
    private final MongoCollection<Document> col = db.getCollection("FlashcardsCollection");
    private final MongoCollection<Document> col2 = db.getCollection("FlashcardsCollection2");
    private final MongoCollection<Document> col3 = db.getCollection("FlashcardsCollection3");


    protected MongoClient getClient() {
        return this.client;
    }

    protected MongoDatabase getDb() {
        return this.db;
    }

    protected MongoCollection<Document> getCollection() {
        return this.col;
    }

    protected MongoCollection<Document> getCollection2() {
        return this.col2;
    }

    protected MongoCollection<Document> getCollection3() {
        return this.col3;
    }
}