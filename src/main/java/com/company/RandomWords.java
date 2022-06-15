package com.company;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.model.Aggregates;
import org.bson.Document;

import java.util.List;

public class RandomWords {
    Database database = new Database();
    Document update = new Document().append("$set", new Document().append("Is_in_apk", true));

    public void getNewWords() {
        AggregateIterable<Document> list = database.getCollection().aggregate(List.of(Aggregates.sample(10)));
        // VV  quantity of documents before update VV
        for (Document document : list) {
            database.getCollection().updateOne(document, update);
            Document tempDocument = database.getCollection().find(new Document("_id", document.get("_id"))).first();
            if (tempDocument != null) {
                database.getCollection2().insertOne(tempDocument);
                database.getCollection().findOneAndDelete(new Document("_id", document.get("_id")));
            }
        }
        GetWords.updateList();
    }
}