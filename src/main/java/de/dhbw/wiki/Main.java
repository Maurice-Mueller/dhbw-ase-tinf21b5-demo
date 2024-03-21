package de.dhbw.wiki;

import de.dhbw.wiki.view.MainView;

public class Main {

    public static void main(String[] args) {
        WikiEntryRepository wikiEntryRepository = new WikiEntryRepository();
        CreateWikiEntryService wikiEntryService = new CreateWikiEntryService(wikiEntryRepository);
        new MainView(wikiEntryRepository, wikiEntryService).show();
    }
}
