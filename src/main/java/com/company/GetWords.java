package com.company;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.NoSuchElementException;


public class GetWords {
    RandomWords randomWords = new RandomWords();
    Database database = new Database();
    static FindIterable<Document> list;
    static MongoCursor<Document> cursor;
    static Document currentWord;
    static int count = 0;


    GetWords() {
        list = database.getCollection2().find();
        cursor = list.iterator();
    }

    public void firstWord() {
        try {
            currentWord = list.first();
            cursor.next();
        } catch (NoSuchElementException e) {
            randomWords.getNewWords();
            firstWord();
        }
    }

    public void getWord() {
        if (cursor.hasNext()) {
            currentWord = cursor.next();
            count += 1;
        } else {
            Window.popUpMessage();
            Window.disableButtons();
        }
    }

    public static void updateList() {
        new GetWords();
        list.skip(count);
        cursor = list.iterator();
    }
}