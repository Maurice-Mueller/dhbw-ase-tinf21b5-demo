package de.dhbw.wiki;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class WikiEntryRepository {

    private final static AtomicLong ID_COUNTER = new AtomicLong();

    private final Map<Long, WikiEntry> entries = new HashMap<>();

    public static long getNextId() {
        return ID_COUNTER.incrementAndGet();
    }

    public WikiEntry getWikiEntry(long id) {
        return entries.get(id);
    }

    public void saveWikiEntry(WikiEntry wikiEntry) {
        if (entries.containsKey(wikiEntry.id())) {
            entries.put(wikiEntry.id(), wikiEntry.copyWithLastUpdated(LocalDateTime.now()));
            return;
        }
        entries.put(wikiEntry.id(), wikiEntry);
    }

    public Collection<WikiEntry> getAll() {
        return entries.values();
    }

}
