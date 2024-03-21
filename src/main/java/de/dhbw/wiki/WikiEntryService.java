package de.dhbw.wiki;

public class WikiEntryService {


    private final WikiEntryRepository wikiEntryRepository;

    public WikiEntryService(WikiEntryRepository wikiEntryRepository) {
        this.wikiEntryRepository = wikiEntryRepository;
    }

    public void saveWikiEntry(String content, String author) {
        WikiEntry entry = new WikiEntry(content, author);
        wikiEntryRepository.saveWikiEntry(entry);
    }


    public WikiEntry getWikiEntry(long entryId) {
        return wikiEntryRepository.getWikiEntry(entryId);
    }

}
