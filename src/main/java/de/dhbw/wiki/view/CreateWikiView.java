package de.dhbw.wiki.view;

import de.dhbw.wiki.CreateWikiEntryService;

import java.util.Scanner;

public class CreateWikiView implements View {

    private final CreateWikiEntryService createWikiEntryService;

    public CreateWikiView(CreateWikiEntryService createWikiEntryService) {
        this.createWikiEntryService = createWikiEntryService;
    }

    @Override
    public void show() {
        System.out.println();
        System.out.println("Enter content:");
        String content = new Scanner(System.in).nextLine();
        System.out.println("Enter author:");
        String author = new Scanner(System.in).nextLine();
        createWikiEntryService.saveWikiEntry(content, author);
    }

}
