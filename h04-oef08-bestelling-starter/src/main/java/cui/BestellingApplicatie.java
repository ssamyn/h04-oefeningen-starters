package cui;

import domein.Bestelling;
import domein.DomeinController;

import java.util.List;
import java.util.Scanner;

public class BestellingApplicatie {
    private static final String[] KEUZES = {"Nieuwe bestelling plaatsen", "Overzicht bestellingen tonen", "Stoppen"};
    private Scanner invoer = new Scanner(System.in);
    private final DomeinController dc;

    public BestellingApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    public void start() {
        System.out.println("HOGENT BESTELLINGEN\n");
        int keuze;
        do {
            keuze = Menu.geefKeuzeUitMenu("MENU", KEUZES);
            switch (keuze) {
                case 1 -> maakNieuweBestelling();
                case 2 -> toonBestellingen();
                case 3 -> System.out.println("Tot een volgende keer...");
            }
            System.out.println();
        } while (keuze != 3);
    }

    private void toonBestellingen() {
        List<String> overzicht = dc.geefBestellingen();
        if (overzicht.isEmpty()) {
            System.out.println("Er werden geen bestellingen gevonden.");
            return;
        }
        for (String bestelling : overzicht) {
            System.out.println(bestelling);
        }
    }

    private void maakNieuweBestelling() {
        boolean bestellingOK = false;
        do {
            // TODO validatie -> exceptions uit domein opvangen en afhandelen
            int printers = vraagAantal("Geef aantal printers: ", Bestelling.MAX_PRINTERS);
            int scanners = vraagAantal("Geef aantal scanners: ", Bestelling.MAX_SCANNERS);
            int laptops = vraagAantal("Geef aantal laptops: ", Bestelling.MAX_LAPTOPS);
            dc.voegBestellingToe(printers, laptops, scanners);
            System.out.println("Je bestelling werd geplaatst...\n");
            bestellingOK = true;
        } while (!bestellingOK);
    }

    private int vraagAantal(String vraag, int maximum) {
        int aantal = 0;
        boolean invoerOK = false;
        do {
            // TODO validatie -> ongeldige invoer afhandelen
            System.out.print(vraag);
            aantal = Integer.parseInt(invoer.nextLine());
            invoerOK = aantal >= 0 && aantal <= maximum;
        } while (!invoerOK);
        return aantal;
    }
}