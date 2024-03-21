package de.dhbw.wiki.view;

import de.dhbw.wiki.WikiEntry;
import de.dhbw.wiki.WikiEntryRepository;

import java.util.Scanner;

public class GetWikiView implements View {

    private final WikiEntryRepository wikiEntryRepository;

    public GetWikiView(WikiEntryRepository wikiEntryRepository) {
        this.wikiEntryRepository = wikiEntryRepository;
    }


    @Override
    public void show() {
        System.out.println();
        System.out.println("What entry do you want?");
        String entryIdString = new Scanner(System.in).nextLine();
        try {
            long entryId = Long.parseLong(entryIdString);
            WikiEntry wikiEntry = wikiEntryRepository.getWikiEntry(entryId);
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