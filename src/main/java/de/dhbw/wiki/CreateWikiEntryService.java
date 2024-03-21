package de.dhbw.wiki;

public class CreateWikiEntryService {


    private final WikiEntryRepository wikiEntryRepository;

    public CreateWikiEntryService(WikiEntryRepository wikiEntryRepository) {
        this.wikiEntryRepository = wikiEntryRepository;
    }

    public void saveWikiEntry(String content, String author) {
        WikiEntry entry = new WikiEntry(content, author);
        wikiEntryRepository.saveWikiEntry(entry);
    }

}
