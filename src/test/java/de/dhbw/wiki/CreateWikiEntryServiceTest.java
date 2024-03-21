package de.dhbw.wiki;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreateWikiEntryServiceTest {

    @Test
    void testCreateEntry() {
        WikiEntryRepository wikiEntryRepository = new WikiEntryRepository();
        CreateWikiEntryService wikiEntryService = new CreateWikiEntryService(wikiEntryRepository);
        wikiEntryService.saveWikiEntry("Hello", "world");

        assertThat(wikiEntryRepository.getAll())
                .hasSize(1)
                .allMatch(it -> it.content().equals("Hello") && it.author().equals("world"));
    }

}