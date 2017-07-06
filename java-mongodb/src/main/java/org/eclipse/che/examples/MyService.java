package org.eclipse.che.examples;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/*
 * TODO
 * - How to add console outpur aspect to all methods
 * - POJO based document
 * 
 */

public class MyService {

    public void addOneToCollection(MongoDatabase db, String collectionName) {
        MongoCollection<Document> collection = db.getCollection(collectionName);

        // Create a document JSON
        Document doc =
           new Document("name", "MongoDB").append("type", "database").append("count", 1)
                                      .append("info", new Document("x", 203).append("y", 102));
         collection.insertOne(doc);
    }

    public void displayCollection(MongoDatabase db, String collectionName) {
        MongoCollection<Document> collection = db.getCollection(collectionName);
        for (Document cur : collection.find()) {
            System.out.println(cur.toJson());
        }
    }
}
