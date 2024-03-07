package de.dhbw.wikientry;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WikiEntryRepositoryTest {

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