package de.dhbw.wiki;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WikiEntryRepositoryMock implements WikiEntryRepository {

    private final Map<UUID, WikiEntry> entries = new HashMap<>();

    @Override
    public WikiEntry getWikiEntry(UUID id) {
        return entries.get(id);
    }

    @Override
    public void saveWikiEntry(WikiEntry wikiEntry) {
        entries.put(wikiEntry.id(), wikiEntry);
    }

    @Override
    public Collection<WikiEntry> getAll() {
        return entries.values();
    }

    @Override
    public void deleteAll() {
        entries.clear();
    }
}
