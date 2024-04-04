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
import java.util.UUID;
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
        getWikiEntryCollection(collection -> collection.insertOne(wikiEntryToDocument(wikiEntry)));
    }

    private Document wikiEntryToDocument(WikiEntry wikiEntry) {
        Document document = new Document();
        document.put("id", wikiEntry.id().toString());
        document.put("content", wikiEntry.content());
        document.put("author", wikiEntry.author());
        return document;
    }

    public List<WikiEntry> getAllWikiEntry() {
        final List<WikiEntry> list = new ArrayList<>();

        getWikiEntryCollection(collection -> {
            collection.find().forEach(document -> {
                list.add(transformToWikiEntry(document));
            });
        });

        return list;
    }

    private WikiEntry transformToWikiEntry(Document document) {
        return new WikiEntry(
                        UUID.fromString(document.getString("id")),
                        document.getString("content"),
                        document.getString("author"),
                        LocalDateTime.now(), // TODO
                        LocalDateTime.now(), // TODO
                        List.of()
                );
    }

    public void deleteAllWikiEntries() {
        getWikiEntryCollection(collection -> collection.deleteMany(new Document()));
    }

    public WikiEntry getWikiEntry(UUID id) {
        final List<WikiEntry> list = new ArrayList<>();

        getWikiEntryCollection(collection -> {
            Document document = collection.find(eq("id", id.toString())).first();

            list.add(transformToWikiEntry(document));

        });

        if (list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

}
