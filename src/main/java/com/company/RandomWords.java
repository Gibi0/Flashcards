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
//        list.forEach(System.out::println);
        // VV  quantity of documents before update VV
        for (Document document : list) {
            database.getCollection().updateOne(document, update);
            Document tempDocument =  database.getCollection().find(new Document("_id",document.get("_id"))).first();
            if (tempDocument != null) {
                database.getCollection2().insertOne(tempDocument);
                database.getCollection().findOneAndDelete(new Document("_id",document.get("_id")));
            }
        }
        GetWords.updateList();
//        int variable = (int) database.getCollection().countDocuments();
//        while (maxNumber < 50) {
//            randomNumber = random.nextInt((int) database.getCollection().countDocuments() + (int) database.getCollection2().countDocuments()) + 1;
//            d = database.getCollection().find(new Document("_id", randomNumber));
//                if (Objects.requireNonNull(d.first()).getBoolean("Is_in_apk").equals(false)) {
//                    database.getCollection().updateOne(new Document("_id", randomNumber), update);
//                    Document tempDocument = (Document) database.getCollection().find(new Document("_id", randomNumber));
//                    database.getCollection2().insertOne(tempDocument);
//                    database.getCollection().findOneAndDelete(new Document("_id", randomNumber));
//                    maxNumber += 1;
//                }
//                if (Objects.requireNonNull(d.first()).getBoolean("Is_in_apk").equals(true)) {
//                    Document tempDocument = database.getCollection().find(new Document("_id", randomNumber)).first();
//                    if (tempDocument != null) {
//                        database.getCollection2().insertOne(tempDocument);
//                        database.getCollection().findOneAndDelete(new Document("_id", randomNumber));
//                    }
//            }
//            while (temp <= variable) {
//                g = database.getCollection().find(new Document("_id", temp));
//                if (temp == variable) {
//                    maxNumber = 50;
//                    break;
//                }
//                if (Objects.requireNonNull(g.first()).getBoolean("Is_in_apk").equals(true)) {
//                    temp += 1;
//                }
//                if (Objects.requireNonNull(g.first()).getBoolean("Is_in_apk").equals(false)) {
//                    break;
//                }
//
//            }
//            }
    }
}

