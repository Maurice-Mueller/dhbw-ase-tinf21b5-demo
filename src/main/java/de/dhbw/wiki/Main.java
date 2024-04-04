package de.dhbw.wiki;

import de.dhbw.wiki.view.MainView;

public class Main {

    public static void main(String[] args) {
        WikiEntryRepository wikiEntryRepository = new WikiEntryMongoDBRepository();
        WikiEntryService wikiEntryService = new WikiEntryService(wikiEntryRepository);
        new MainView(wikiEntryService).show();
    }
}
