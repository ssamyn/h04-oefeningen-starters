package cui;

import domein.Bestelling;
import domein.DomeinController;

import java.util.List;

public class BestellingApplicatie {
    private final DomeinController dc;
    private final Menu menu;

    public BestellingApplicatie(DomeinController dc) {
        this.dc = dc;
        this.menu = new Menu("BESTELLINGEN", new String[]{"Nieuwe bestelling plaatsen", "Overzicht bestellingen tonen", "Stoppen"});
    }

    public void start() {
        System.out.println("HOGENT Bestellingen printers, scanner en laptops\n");
        int keuze;
        do {
            keuze = menu.geefKeuzeUitMenu();
            switch (keuze) {
                case 1 -> maakNieuweBestelling();
                case 2 -> toonBestellingen();
            }
        } while (keuze != 3);
        System.out.println("Tot een volgende keer...");
    }

    private void toonBestellingen() {
        List<String> overzicht = dc.geefBestellingen();
        if (overzicht.isEmpty()) {
            System.out.println("Er werden geen bestellingen gevonden.\n\n");
            return;
        }
        for (String bestelling : overzicht) {
            System.out.printf("- %s%n", bestelling);
        }
        System.out.printf("%n%n");
    }

    private void maakNieuweBestelling() {
        boolean bestellingOK = false;
        do {
            int printers = IO.geefGeheelGetal("Geef aantal printers", 0, Bestelling.MAX_PRINTERS);
            int scanners = IO.geefGeheelGetal("Geef aantal scanners", 0, Bestelling.MAX_SCANNERS);
            int laptops = IO.geefGeheelGetal("Geef aantal laptops", 0, Bestelling.MAX_LAPTOPS);

            // TODO
            dc.voegBestellingToe(printers, laptops, scanners);
            System.out.println("✅ Je bestelling werd succesvol geplaatst...\n");
            bestellingOK = true;

        } while (!bestellingOK);
    }
}