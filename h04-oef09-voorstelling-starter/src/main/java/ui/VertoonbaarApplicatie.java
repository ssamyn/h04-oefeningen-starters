package ui;

import domein.DomeinController;
import domein.Film;
import util.Actie;

public class VertoonbaarApplicatie {

    private final DomeinController dc;
    private final Menu overzichtsMenu, toevoegenMenu, zaalMenu;

    public VertoonbaarApplicatie(DomeinController dc) {
        this.dc = dc;
        overzichtsMenu = new Menu(Actie.OVERZICHT.getTitel(), Actie.OVERZICHT.getKeuzes());
        toevoegenMenu = new Menu(Actie.TOEVOEGEN.getTitel(), Actie.TOEVOEGEN.getKeuzes());
        zaalMenu = new Menu(Actie.ZAAL.getTitel(), Actie.ZAAL.getKeuzes());
    }

    public void start() {
        System.out.println("HOGENT Films en concerten\n");
        int keuze = overzichtsMenu.geefKeuzeUitMenu();
        while (keuze != 4) {
            switch (keuze) {
                case 1 -> drukOverzichtVoorstellingenAf();
                case 2 -> voegVoorstellingToe();
                case 3 -> toonAantalVoorstellingenInZaal();
            }
            keuze = overzichtsMenu.geefKeuzeUitMenu();
        }
        System.out.println("Tot een volgende keer...");
    }

    private void drukOverzichtVoorstellingenAf() {
        System.out.println("Overzicht voorstellingen:");
        for (String voorstelling : dc.geefAlleVoorstellingen())
            System.out.printf("- %s%n", voorstelling);
        System.out.printf("%n%n");
    }

    private void voegVoorstellingToe() {
        int keuze = toevoegenMenu.geefKeuzeUitMenu();
        switch (keuze) {
            case 1 -> voegFilmToe();
            case 2 -> voegConcertToe();
        }
    }

    private void voegFilmToe() {
        String naam = IO.geefEenNietLegeString("Geef de naam van de film");
        int jaar = IO.geefGeheelGetal(String.format("Geef het jaar waarin de film uitkwam (%d - %d)", Film.MIN_JAAR, Film.HUIDIG_JAAR),
                Film.MIN_JAAR, Film.HUIDIG_JAAR);
        int sterren = IO.geefGeheelGetal(String.format("Geef het aantal sterren dat de film verdient (%d - %d)", Film.MIN_STERREN, Film.MAX_STERREN),
                Film.MIN_STERREN, Film.MAX_STERREN);
        
        dc.voegVoorstellingToe(naam, jaar, sterren);
        System.out.println("✅ Film werd succesvol toegevoegd.\n\n");
    }

    private void voegConcertToe() {
        String artiest = IO.geefEenNietLegeString("Geef de naam van de artiest");
        String naam = IO.geefEenNietLegeString("Geef de benaming van het concert");

        dc.voegVoorstellingToe(artiest, naam);
        System.out.println("✅ Concert werd succesvol toegevoegd.\n\n");

    }

    private void toonAantalVoorstellingenInZaal() {
        int keuze = zaalMenu.geefKeuzeUitMenu();
        if (keuze != Actie.ZAAL.getKeuzes().length)
            System.out.printf("Het aantal voorstellingen in deze zaal bedraagt %d%n%n",
                    dc.geefAantalInZaal(keuze));
    }

}