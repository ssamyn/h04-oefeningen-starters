package ui;

import static ui.IO.FOUT_PREFIX;
import static ui.IO.INVOER;

public class Menu {
    private String[] keuzes;
    private String titel;

    public Menu(String titel, String[] keuzes) {
        setKeuzes(keuzes);
        setTitel(titel);
    }

    public int geefKeuzeUitMenu() {
        int keuze = -1;
        boolean invoerOK = false;
        do {
            try {
                toonMenu();
                keuze = Integer.parseInt(INVOER.nextLine());
                invoerOK = keuze >= 1 && keuze <= keuzes.length;
                if (!invoerOK)
                    System.out.printf("%sOngeldige keuze. Kies een optie tussen 1 en %d.%n%n", FOUT_PREFIX, keuzes.length);
            } catch (NumberFormatException e) {
                System.out.printf("%sOngeldige keuze, voer een getal in.%n%n", FOUT_PREFIX);
            }
        } while (!invoerOK);
        System.out.println();
        return keuze;
    }

    private void toonMenu() {
        System.out.printf("%s%n%s%n", titel, "=".repeat(titel.length()));
        for (int i = 0; i < keuzes.length; i++)
            System.out.printf("%d. %s%n", i + 1, keuzes[i]);
        System.out.printf("Geef je keuze (1 - %d) > ", keuzes.length);
    }

    private void setKeuzes(String[] keuzes) {
        if (keuzes == null || keuzes.length == 0)
            throw new IllegalArgumentException("Een menu moet minstens 1 keuze bevatten.");
        this.keuzes = keuzes;
    }

    private void setTitel(String titel) {
        if (titel == null || titel.isBlank())
            throw new IllegalArgumentException("Een menu moet een titel hebben.");
        this.titel = titel;
    }
}