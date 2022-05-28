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
    int x;

    public MongoClient getClient(){
        return this.client;
    }
    public MongoDatabase getDb(){
        return this.db;
    }
    public MongoCollection<Document> getCollection(){
        return this.col;
    }
}
