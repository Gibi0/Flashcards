package com.company;

import com.mongodb.client.FindIterable;
import org.bson.Document;

import java.util.Objects;
import java.util.Random;

public class RandomWords {
    Database database = new Database();
    Random random = new Random();
    int i = 0, number, z = 1;
    Document update = new Document().append("$set", new Document().append("Is_in_apk", true));
    FindIterable<Document> g,d;

    public void getWords() {
        int variable = (int) database.getCollection().countDocuments();
        while (i < 50) {
            number = random.nextInt((int) database.getCollection().countDocuments()) + 1;
            d = database.getCollection().find(new Document("_id", number));
            if (Objects.requireNonNull(d.first()).getBoolean("Is_in_apk").equals(false)) {
                database.getCollection().updateOne(new Document("_id", number), update);

                i += 1;
            }

            while (z <= variable) {
                g = database.getCollection().find(new Document("_id", z));
                if (z == variable) {
                    i = 50;
                    break;
                }
                if (Objects.requireNonNull(g.first()).getBoolean("Is_in_apk").equals(true)) {
                    z += 1;
                }
                if (Objects.requireNonNull(g.first()).getBoolean("Is_in_apk").equals(false)) {
                    break;
                }

            }
        }
    }
}

