package de.dhbw.wiki;

import de.dhbw.wiki.db.MongoDBConnector;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class WikiEntryRepository {

    private final static AtomicLong ID_COUNTER = new AtomicLong();


    private final MongoDBConnector mongoDBConnector = new MongoDBConnector();

    public static long getNextId() {
        return ID_COUNTER.incrementAndGet();
    }
    public WikiEntry getWikiEntry(long id) {
        return mongoDBConnector.getWikiEntry(id);
    }

    public void saveWikiEntry(WikiEntry wikiEntry) {
        mongoDBConnector.saveWikiEntry(wikiEntry);
    }

    public Collection<WikiEntry> getAll() {
        return List.of(); // TODO
    }

}
