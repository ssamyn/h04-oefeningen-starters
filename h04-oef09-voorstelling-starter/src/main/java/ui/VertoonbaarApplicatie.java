package ui;

import domein.DomeinController;
import exceptions.LegeStringException;
import util.Actie;

import java.util.Scanner;

public class VertoonbaarApplicatie {

    private final DomeinController dc;
    private final Scanner invoer = new Scanner(System.in);

    public VertoonbaarApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    public void start() {
        int keuze = geefKeuze(Actie.OVERZICHT);
        while (keuze != 4) {
            switch (keuze) {
                case 1 -> drukOverzichtVoorstellingenAf();
                case 2 -> voegVoorstellingToe();
                case 3 -> toonAantalVoorstellingenInZaal();
            }
            keuze = geefKeuze(Actie.OVERZICHT);
        }
    }

    private void drukOverzichtVoorstellingenAf() {
        System.out.println("\nOverzicht voorstellingen:");
        for (String voorstelling : dc.geefAlleVoorstellingen())
            System.out.printf("- %s%n", voorstelling);
    }

    private void voegVoorstellingToe() {
        String[] gegevens;
        int keuze = geefKeuze(Actie.TOEVOEGEN);
        switch (keuze) {
            case 1 -> gegevens = geefGegevensVanFilm();
            case 2 -> gegevens = geefGegevensVanConcert();
            default -> {
                return;
            }
        }
        try {
            dc.voegVoorstellingToe(gegevens);
            System.out.println("Voorstelling toegevoegd...");
        } catch (NumberFormatException e) {
            System.out.println("Voorstelling werd niet geregistreerd: aantal sterren en jaar moeten een geheel getal zijn");
        } catch (LegeStringException | IllegalArgumentException e) {
            System.out.println("Voorstelling werd niet geregistreerd: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Onverwachte fout! De voorstelling kon niet geregistreerd worden");
        }
    }

    private String[] geefGegevensVanFilm() {
        System.out.print("Geef de naam van de film: ");
        String naam = invoer.nextLine();
        System.out.print("Geef het jaar waarin de film uitkwam: ");
        String jaar = invoer.nextLine();
        System.out.print("Hoeveel sterren verdient deze film: ");
        String sterren = invoer.nextLine();
        return new String[]{naam, sterren, jaar};
    }

    private String[] geefGegevensVanConcert() {
        System.out.print("Geef de naam van de artiest: ");
        String artiest = invoer.nextLine();
        System.out.print("Geef de benaming van het concert: ");
        String naam = invoer.nextLine();
        return new String[]{artiest, naam};
    }

    private void toonAantalVoorstellingenInZaal() {
        int keuze = geefKeuze(Actie.ZAAL);
        if (keuze != Actie.ZAAL.getKeuzes().length)
            System.out.printf("Het aantal voorstellingen in deze zaal bedraagt %d%n",
                    dc.geefAantalInZaal(keuze));
    }

    private int geefKeuze(Actie actie) {
        return Menu.geefKeuze(actie.getTitel(), actie.getKeuzes());
    }
}