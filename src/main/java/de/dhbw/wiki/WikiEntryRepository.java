package de.dhbw.wiki;

import java.util.Collection;
import java.util.UUID;

public interface WikiEntryRepository {


    WikiEntry getWikiEntry(UUID id);

    void saveWikiEntry(WikiEntry wikiEntry);

    Collection<WikiEntry> getAll();

    void deleteAll();
}
