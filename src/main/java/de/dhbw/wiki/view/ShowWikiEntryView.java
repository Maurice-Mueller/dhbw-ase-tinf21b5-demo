package de.dhbw.wiki.view;

import de.dhbw.wiki.WikiEntry;
import de.dhbw.wiki.WikiEntryService;

import java.util.Scanner;
import java.util.UUID;

public class ShowWikiEntryView implements View {

    private final WikiEntryService wikiEntryService;

    public ShowWikiEntryView(WikiEntryService wikiEntryService) {
        this.wikiEntryService = wikiEntryService;
    }


    @Override
    public void show() {
        System.out.println();
        System.out.println("What entry do you want?");
        String entryIdString = new Scanner(System.in).nextLine();
        try {
            UUID entryId = UUID.fromString(entryIdString);
            WikiEntry wikiEntry = wikiEntryService.getWikiEntry(entryId);
            if(wikiEntry == null) {
                System.out.println("Entry does not exist.");
                return;
            }
            System.out.println("Content:");
            System.out.println(wikiEntry.content());
        } catch (NumberFormatException exception) {
            System.out.println("Wrong input");
        }
    }
}
