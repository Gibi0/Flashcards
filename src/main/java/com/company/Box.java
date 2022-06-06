package com.company;

import com.mongodb.client.FindIterable;
import org.bson.Document;

public class Box {
    static Database database = new Database();

    public static void boxUpdateUp() {
        database.getCollection2().findOneAndUpdate(GetWords.currentWord, new Document().append("$set", new Document().append("Box_ID", GetWords.currentWord.getInteger("Box_ID")+1)));
    }
    public static void boxReturnToFirst(){
        database.getCollection2().findOneAndUpdate(GetWords.currentWord, new Document().append("$set", new Document().append("Box_ID", 1)));
    }
}
