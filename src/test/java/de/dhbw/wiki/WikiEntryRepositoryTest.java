package de.dhbw.wiki;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WikiEntryRepositoryTest {

    @Test
    void testAddNewEntry() {
        // arrange
        WikiEntryRepository wikiEntryRepository = new WikiEntryRepository();
        WikiEntry wikiEntry = new WikiEntry();

        // act
        wikiEntryRepository.saveWikiEntry(wikiEntry);

        // assert
        assertThat(wikiEntry.lastUpdated()).isNull();
    }

    @Test
    void testUpdateLastUpdated() {
        // arrange
        WikiEntry wikiEntry = new WikiEntry();
        WikiEntryRepository wikiEntryRepository = new WikiEntryRepository();
        wikiEntryRepository.saveWikiEntry(wikiEntry);

        // act
        wikiEntryRepository.saveWikiEntry(wikiEntry);

        // assert
        WikiEntry currentEntry = wikiEntryRepository.getWikiEntry(wikiEntry.id());
        assertThat(currentEntry.lastUpdated()).isNotNull();
    }

}