package ui;

import domein.DomeinController;

import java.util.Scanner;

public class DraagbaarApplicatie {
    private final DomeinController dc;
    private Scanner invoer;
    private final static String[] KEUZES = {"Voeg wapen toe", "Voeg sleutel toe", "Voeg gebouw toe", "Toon huidig overzicht", "Beëindig deze applicatie"};

    public DraagbaarApplicatie(DomeinController dc) {
        this.dc = dc;
        invoer = new Scanner(System.in);
    }


    public void start() {
        System.out.println("HOGENT VOORWERPEN\n");
        int keuze;
        do {
            keuze = Menu.geefKeuzeUitMenu("MENU", KEUZES);
            boolean gegevensCorrect = false;
            do {
                // TODO gebruik try-catch en handel NumberFormatExceptions en IllegalArgumentExceptions af
                switch (keuze) {
                    case 1 -> voegWapenToe();
                    case 2 -> voegSleutelToe();
                    case 3 -> voegGebouwToe();
                    case 4 -> System.out.printf("%s", dc.geefOverzicht());
                    case 5 -> System.out.printf("Tot een volgende keer...");
                }
                gegevensCorrect = true;
            } while (!gegevensCorrect);
        } while (keuze != 5);


    }

    private void voegGebouwToe() {
        String naam = vraagNaam();
        System.out.print("Geef de hoogte: ");
        double hoogte = Double.parseDouble(invoer.nextLine());
        dc.voegGebouwToe(naam, hoogte);
        System.out.printf("%n%n");
    }

    private void voegSleutelToe() {
        String naam = vraagNaam();
        System.out.print("Geef het gewicht: ");
        double gewicht = Double.parseDouble(invoer.nextLine());
        System.out.print("Geef het niveau: ");
        int niveau = Integer.parseInt(invoer.nextLine());
        System.out.print("Geef het nummer van de deur: ");
        int deur = Integer.parseInt(invoer.nextLine());
        dc.voegSleutelToe(naam, gewicht, niveau, deur);
        System.out.printf("%n%n");
    }

    private void voegWapenToe() {
        String naam = vraagNaam();
        System.out.print("Geef het gewicht: ");
        double gewicht = Double.parseDouble(invoer.nextLine());
        System.out.print("Geef het niveau: ");
        int niveau = Integer.parseInt(invoer.nextLine());
        System.out.print("Geef de kracht: ");
        int kracht = Integer.parseInt(invoer.nextLine());
        System.out.print("Werd het wapen reeds gebruikt (true/false)? ");
        boolean gebruikt = Boolean.parseBoolean(invoer.nextLine());
        dc.voegWapenToe(naam, gewicht, niveau, kracht, gebruikt);
        System.out.printf("%n%n");
    }

    private String vraagNaam() {
        System.out.print("Geef de naam op: ");
        String naam = invoer.nextLine();
        // TODO als de naam spaties bevat werp een IllegalArgumentException
        return naam;
    }
}