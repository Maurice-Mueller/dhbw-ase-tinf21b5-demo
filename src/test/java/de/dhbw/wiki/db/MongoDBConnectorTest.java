package de.dhbw.wiki.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.dhbw.wiki.WikiEntry;
import org.bson.Document;
import org.junit.jupiter.api.Test;

import static com.mongodb.client.model.Filters.eq;


class MongoDBConnectorTest {

    @Test
    void test() {
        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb://demo:helloworld@localhost:27017/";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("wiki");
            MongoCollection<Document> collection = database.getCollection("wiki_entry");
            WikiEntry wikiEntry = new WikiEntry("Content", "Author");

            Document document = new Document();

            document.put("id", wikiEntry.id());
            document.put("content", wikiEntry.content());
            document.put("author", wikiEntry.author());

            collection.insertOne(document);

            Document doc = collection.find(eq("author", "Author")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }

}