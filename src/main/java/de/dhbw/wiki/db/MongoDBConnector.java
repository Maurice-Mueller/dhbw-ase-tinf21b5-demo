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
import java.util.function.Function;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBConnector {

    private final String uri = "mongodb://demo:helloworld@localhost:27017/";


    private <T> T getWikiEntryCollection(Function<MongoCollection<Document>, T> function) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("wiki");
            MongoCollection<Document> collection = database.getCollection("wiki_entry");
            return function.apply(collection);
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
        return getWikiEntryCollection(collection -> {
                    List<WikiEntry> result = new ArrayList<>();
                    collection.find().map(this::transformToWikiEntry).into(result);
                    return result;
                }
        );
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
        return getWikiEntryCollection(collection ->
            collection.find(eq("id", id.toString())).map(this::transformToWikiEntry).first()
        );
    }

}
