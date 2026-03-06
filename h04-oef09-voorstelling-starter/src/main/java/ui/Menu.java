package ui;

import java.util.Scanner;

public class Menu {
    private static Scanner invoer = new Scanner(System.in);

    public static int geefKeuzeUitMenu(String titel, String[] keuzes) {
        int keuze = -1;
        boolean invoerOK = false;
        do {
            try {
                toonMenu(titel, keuzes);
                keuze = Integer.parseInt(invoer.nextLine());
                invoerOK = keuze >= 1 && keuze <= keuzes.length;
                if (!invoerOK)
                    System.out.printf("[!] Ongeldige keuze. Kies een optie tussen 1 en %d%n%n.", keuzes.length);
            } catch (NumberFormatException e) {
                System.out.printf("[!] Ongeldige keuze, voer een getal in%n%n");
            }
        } while (!invoerOK);
        System.out.println();
        return keuze;
    }

    private static void toonMenu(String titel, String[] keuzes) {
        System.out.printf("%s%n%s%n", titel, "=".repeat(titel.length()));
        for (int i = 0; i < keuzes.length; i++)
            System.out.printf("%d. %s%n", i + 1, keuzes[i]);
        System.out.printf("Geef je keuze (1 - %d) >  ", keuzes.length);
    }

}