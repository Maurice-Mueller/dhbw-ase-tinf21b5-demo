package de.dhbw.wiki.view;

import de.dhbw.wiki.WikiEntryRepository;

import java.util.Scanner;

public class MainView implements View {

    private final WikiEntryRepository wikiEntryRepository;

    public MainView(WikiEntryRepository wikiEntryRepository) {
        this.wikiEntryRepository = wikiEntryRepository;
    }

    public void show() {
        System.out.println("Hello in our application");
        System.out.println();


        while (true) {
            String menuInput = getMainMenuInput();

            if (menuInput.equals("1")) {
                new GetWikiView(wikiEntryRepository).show();
            } else if (menuInput.equals("2")) {
                new CreateWikiView(wikiEntryRepository).show();
            } else if (menuInput.equals("0")) {
                System.out.println("Good bye.");
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
    }

    private String getMainMenuInput() {
        System.out.println("What do you want to do?");
        System.out.println("[1]: Get wiki entry");
        System.out.println("[2]: New wiki entry");
        System.out.println("[0]: exit");
        return new Scanner(System.in).nextLine();
    }


}
