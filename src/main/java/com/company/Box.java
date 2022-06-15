package com.company;

import org.bson.Document;

public class Box {
    static Database database = new Database();

    public static void boxUpdateUp() {
        database.getCollection2().findOneAndUpdate(GetWords.currentWord, new Document().append("$set", new Document().append("Box_ID", GetWords.currentWord.getInteger("Box_ID") + 1)));
        GetWords.currentWord = database.getCollection2().find(new Document("_id", GetWords.currentWord.get("_id"))).first();
    }

    public static void boxReturnToFirst() {
        database.getCollection2().findOneAndUpdate(GetWords.currentWord, new Document().append("$set", new Document().append("Box_ID", 1)));
    }

    public static void apkStatusUpdate() {
        database.getCollection3().findOneAndUpdate(GetWords.currentWord, new Document().append("$set", new Document().append("Is_in_apk", false)));
    }

    public static void checkBox() {
        if (GetWords.currentWord != null && GetWords.currentWord.getInteger("Box_ID").equals(6)) {
            database.getCollection3().insertOne(GetWords.currentWord);
            database.getCollection2().findOneAndDelete(GetWords.currentWord);
            apkStatusUpdate();
        }
    }
}