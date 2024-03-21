package de.dhbw.wiki.view;

import de.dhbw.wiki.WikiEntry;
import de.dhbw.wiki.WikiEntryRepository;

import java.util.Scanner;

public class CreateWikiView implements View {

    private final WikiEntryRepository wikiEntryRepository;

    public CreateWikiView(WikiEntryRepository wikiEntryRepository) {
        this.wikiEntryRepository = wikiEntryRepository;
    }

    @Override
    public void show() {
        System.out.println();
        System.out.println("Enter content:");
        String content = new Scanner(System.in).nextLine();
        System.out.println("Enter author:");
        String author = new Scanner(System.in).nextLine();
        WikiEntry entry = new WikiEntry(content, author);
        wikiEntryRepository.saveWikiEntry(entry);
    }
}
