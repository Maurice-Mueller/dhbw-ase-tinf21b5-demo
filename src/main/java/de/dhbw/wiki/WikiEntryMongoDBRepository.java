package de.dhbw.wiki;

import de.dhbw.wiki.db.MongoDBConnector;

import java.util.Collection;
import java.util.UUID;

public class WikiEntryMongoDBRepository implements WikiEntryRepository {

    private final MongoDBConnector mongoDBConnector = new MongoDBConnector();

    @Override
    public WikiEntry getWikiEntry(UUID id) {
        return mongoDBConnector.getWikiEntry(id);
    }

    @Override
    public void saveWikiEntry(WikiEntry wikiEntry) {
        mongoDBConnector.saveWikiEntry(wikiEntry);
    }

    @Override
    public Collection<WikiEntry> getAll() {
        return mongoDBConnector.getAllWikiEntry();
    }

    @Override
    public void deleteAll() {
        mongoDBConnector.deleteAllWikiEntries();
    }

}
