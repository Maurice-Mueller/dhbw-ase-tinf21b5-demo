package de.dhbw.wiki.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.dhbw.wiki.WikiEntry;
import org.bson.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBConnector {

    private final String uri = "mongodb://demo:helloworld@localhost:27017/";


    private void getWikiEntryCollection(Consumer<MongoCollection<Document>> consumer) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("wiki");
            MongoCollection<Document> collection = database.getCollection("wiki_entry");
            consumer.accept(collection);
        }
    }

    public void saveWikiEntry(WikiEntry wikiEntry) {
        Document document = new Document();

        document.put("id", wikiEntry.id());
        document.put("content", wikiEntry.content());
        document.put("author", wikiEntry.author());

        getWikiEntryCollection(collection -> collection.insertOne(document));
    }

    public WikiEntry getWikiEntry(long id) {
        final List<WikiEntry> list = new ArrayList<>();

        getWikiEntryCollection(collection -> {
            Document document = collection.find(eq("id", id)).first();

            list.add(new WikiEntry(
                    document.getLong("id"),
                    document.getString("content"),
                    document.getString("author"),
                    LocalDateTime.now(), // TODO
                    LocalDateTime.now(), // TODO
                    List.of()
            ));

        });

        if(list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

}
