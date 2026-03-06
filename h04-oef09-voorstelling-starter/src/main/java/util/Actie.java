package util;

public enum Actie {
    OVERZICHT("VOORSTELLINGEN", new String[]{"Toon overzicht van de voorstellingen", "Voeg een voorstelling toe", "Geef het het aantal voorstellingen in een bepaalde zaal", "Beëindig het programma"}),
    TOEVOEGEN("VOORSTELLING TOEVOEGEN", new String[]{"Voeg een film toe", "Voeg een concertregistratie toe", "Keer terug naar hoofdmenu"}),
    ZAAL("ZAAL KIEZEN", new String[]{"Zaal 1", "Zaal 2", "Zaal 3", "Keer terug naar hoofdmenu"});

    private String titel;
    private String[] keuzes;

    Actie(String titel, String[] keuzes) {
        this.titel = titel;
        this.keuzes = keuzes;
    }

    public String getTitel() {
        return titel;
    }

    public String[] getKeuzes() {
        return keuzes;
    }
}