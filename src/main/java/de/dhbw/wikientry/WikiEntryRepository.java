package de.dhbw.wikientry;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class WikiEntryRepository {

    private final static AtomicLong ID_COUNTER = new AtomicLong();

    private final Map<Long, WikiEntryRecord> entries = new HashMap<>();

    public static long getNextId() {
        return ID_COUNTER.incrementAndGet();
    }

    public WikiEntryRecord getWikiEntryRecord(long id) {
        return entries.get(id);
    }

    public void saveWikiEntryRecord(WikiEntryRecord wikiEntryRecord) {
        if (entries.containsKey(wikiEntryRecord.id())) {
            entries.put(wikiEntryRecord.id(), wikiEntryRecord.copyWithLastUpdated(LocalDateTime.now()));
            return;
        }
        entries.put(wikiEntryRecord.id(), wikiEntryRecord);
    }

    public Collection<WikiEntryRecord> getAll() {
        return entries.values();
    }

}
