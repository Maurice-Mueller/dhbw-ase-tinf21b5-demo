package de.dhbw.wiki.view;

import de.dhbw.wiki.WikiEntryService;

import java.util.Scanner;

public class CreateWikiEntryView implements View {

    private final WikiEntryService wikiEntryService;

    public CreateWikiEntryView(WikiEntryService wikiEntryService) {
        this.wikiEntryService = wikiEntryService;
    }

    @Override
    public void show() {
        System.out.println();
        System.out.println("Enter content:");
        String content = new Scanner(System.in).nextLine();
        System.out.println("Enter author:");
        String author = new Scanner(System.in).nextLine();
        wikiEntryService.saveWikiEntry(content, author);
    }

}
