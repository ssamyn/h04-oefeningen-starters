package ui;

import java.util.Scanner;

public class Menu {
    private static Scanner invoer = new Scanner(System.in);

    public static int geefKeuze(String titel, String[] keuzes) {
        int keuze = -1;
        boolean invoerOK = false;
        do {
            try {
                toonMenu(titel, keuzes);
                keuze = Integer.parseInt(invoer.nextLine());
                invoerOK = keuze >= 1 && keuze <= keuzes.length;
                if (!invoerOK)
                    System.out.println("Dit is geen geldige keuze. Probeer opnieuw.\n");
            } catch (NumberFormatException e) {
                System.out.println("Voer een geheel getal in.\n");
            }
        } while (!invoerOK);
        return keuze;
    }

    private static void toonMenu(String titel, String[] keuzes) {
        System.out.printf("%n%s%n%s%n", titel, "=".repeat(titel.length()));
        for (int i = 0; i < keuzes.length; i++)
            System.out.printf("%d. %s%n", i + 1, keuzes[i]);
        System.out.print("Geef je keuze > ");
    }

}