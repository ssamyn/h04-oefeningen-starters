package ui;

import domein.DomeinController;

import static ui.IO.FOUT_PREFIX;
import static ui.IO.INVOER;

public class DraagbaarApplicatie {
    private final DomeinController dc;
    private final static String[] KEUZES = {"Voeg wapen toe", "Voeg sleutel toe", "Voeg gebouw toe", "Toon huidig overzicht", "Beëindig deze applicatie"};
    private final Menu menu;

    public DraagbaarApplicatie(DomeinController dc) {
        this.dc = dc;
        menu = new Menu("Gebouwen en voorwerpen", KEUZES);
    }


    public void start() {
        System.out.println("Applicatie interface 'Draagbaar'\n");
        int keuze;
        do {
            keuze = menu.geefKeuzeUitMenu();
            // TODO
            switch (keuze) {
                case 1 -> voegWapenToe();
                case 2 -> voegSleutelToe();
                case 3 -> voegGebouwToe();
                case 4 -> System.out.printf("%s%n%n", dc.geefOverzicht());
            }
        } while (keuze != KEUZES.length);
        System.out.println("Tot een volgende keer...");
    }

    private void voegGebouwToe() {
        String naam = vraagNaam();

        // OUD:
        // System.out.print("Geef de hoogte: ");
        // double hoogte = Double.parseDouble(invoer.nextLine());
        // dc.voegGebouwToe(naam, hoogte);
        // System.out.printf("%n%n");

        // NIEUW:
        double hoogte = IO.geefDecimaalGetal("Geef de hoogte", 3);
        try {
            dc.voegGebouwToe(naam, hoogte);
            System.out.printf("✅ Gebouw succesvol toegevoegd%n%n");
        } catch (IllegalArgumentException e) {
            System.out.printf("%sGebouw werd niet toegevoegd: %s.%n%n", FOUT_PREFIX, e.getMessage());
        }
    }

    private void voegSleutelToe() {
        // TODO
        String naam = vraagNaam();
        System.out.print("Geef het gewicht: ");
        double gewicht = Double.parseDouble(INVOER.nextLine());
        System.out.print("Geef het niveau: ");
        int niveau = Integer.parseInt(INVOER.nextLine());
        System.out.print("Geef het nummer van de deur: ");
        int deur = Integer.parseInt(INVOER.nextLine());
        dc.voegSleutelToe(naam, gewicht, niveau, deur);
        System.out.printf("%n%n");
    }

    private void voegWapenToe() {
        // TODO
        String naam = vraagNaam();
        System.out.print("Geef het gewicht: ");
        double gewicht = Double.parseDouble(INVOER.nextLine());
        System.out.print("Geef het niveau: ");
        int niveau = Integer.parseInt(INVOER.nextLine());
        System.out.print("Geef de kracht: ");
        int kracht = Integer.parseInt(INVOER.nextLine());
        System.out.print("Werd het wapen reeds gebruikt? ");
        boolean gebruikt = Boolean.parseBoolean(INVOER.nextLine());
        dc.voegWapenToe(naam, gewicht, niveau, kracht, gebruikt);
        System.out.printf("%n%n");
    }

    private String vraagNaam() {
        String naam;
        boolean invoerOK;
        do {
            naam = IO.geefEenNietLegeString("Geef de naam");
            invoerOK = !naam.contains(" ");
            if (!invoerOK)
                System.out.printf("%sDe naam mag geen spaties bevatten.%n%n", FOUT_PREFIX);
        } while (!invoerOK);
        return naam;
    }
}