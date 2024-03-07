package de.dhbw.wikientry;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello in our application");
        System.out.println();

        String input = null;
        while (input == null || !input.equals("0")) {
            System.out.println("What do you want to do?");
            System.out.println("[1]: Get wiki entry");
            System.out.println("[2]: New wiki entry");
            System.out.println("[0]: exit");

            input = new Scanner(System.in).nextLine();

            if (input.equals("1")) {
                System.out.println("GET");
            } else if (input.equals("2")) {
                System.out.println("NEW");
            } else if (input.equals("0")) {
                System.out.println("Good bye.");
            } else {
                System.out.println("Wrong input");
            }
        }
    }
}
