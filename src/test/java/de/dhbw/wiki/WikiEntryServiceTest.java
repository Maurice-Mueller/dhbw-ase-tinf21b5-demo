package de.dhbw.wiki;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WikiEntryServiceTest {

    @Test
    void testCreateEntry() {
        WikiEntryRepository wikiEntryRepository = new WikiEntryRepository();
        WikiEntryService wikiEntryService = new WikiEntryService(wikiEntryRepository);
        wikiEntryService.saveWikiEntry("Hello", "world");

        assertThat(wikiEntryRepository.getAll())
                .hasSize(1)
                .allMatch(it -> it.content().equals("Hello") && it.author().equals("world"));
    }

}