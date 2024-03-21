package de.dhbw.wiki;

import de.dhbw.wiki.view.MainView;

public class Main {

    public static void main(String[] args) {
        WikiEntryRepository wikiEntryRepository = new WikiEntryRepository();
        new MainView(wikiEntryRepository).show();
    }
}
