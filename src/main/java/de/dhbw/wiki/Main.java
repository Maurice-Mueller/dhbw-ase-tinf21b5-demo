package de.dhbw.wiki;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello in our application");
        System.out.println();

        WikiEntryRepository wikiEntryRepository = new WikiEntryRepository();

        String menuInput = null;
        while (menuInput == null || !menuInput.equals("0")) {
            System.out.println("What do you want to do?");
            System.out.println("[1]: Get wiki entry");
            System.out.println("[2]: New wiki entry");
            System.out.println("[0]: exit");

            menuInput = new Scanner(System.in).nextLine();

            if (menuInput.equals("1")) {
                System.out.println();
                System.out.println("What entry do you want?");
                String entryIdString = new Scanner(System.in).nextLine();
                try {
                    long entryId = Long.parseLong(entryIdString);
                    WikiEntry wikiEntry = wikiEntryRepository.getWikiEntry(entryId);
                    if(wikiEntry == null) {
                        System.out.println("Entry does not exist.");
                        continue;
                    }
                    System.out.println("Content:");
                    System.out.println(wikiEntry.content());
                } catch (NumberFormatException exception) {
                    System.out.println("Wrong input");
                }

            } else if (menuInput.equals("2")) {
                System.out.println();
                System.out.println("Enter content:");
                String content = new Scanner(System.in).nextLine();
                System.out.println("Enter author:");
                String author = new Scanner(System.in).nextLine();
                WikiEntry entry = new WikiEntry(content, author);
                wikiEntryRepository.saveWikiEntry(entry);
            } else if (menuInput.equals("0")) {
                System.out.println("Good bye.");
            } else {
                System.out.println("Wrong input");
            }
        }
    }
}
