package de.dhbw.wiki;

import de.dhbw.wiki.view.MainView;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        var date = new ArrayList(); // example for compiler warning
        WikiEntryRepository wikiEntryRepository = new WikiEntryRepository();
        WikiEntryService wikiEntryService = new WikiEntryService(wikiEntryRepository);
        new MainView(wikiEntryService).show();
    }
}
