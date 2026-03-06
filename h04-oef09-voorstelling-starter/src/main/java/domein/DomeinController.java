package domein;

import exceptions.LegeStringException;

import java.util.List;

public class DomeinController {

    private final VertoonbaarRepository vertoonbaarRepo;

    public DomeinController() throws LegeStringException {
        vertoonbaarRepo = new VertoonbaarRepository();
    }

    public void voegVoorstellingToe(String[] infoVoorstelling) throws LegeStringException {
        boolean isFilm = infoVoorstelling.length == 3;
        if (isFilm) {
            String naam = infoVoorstelling[0];
            int sterren = Integer.parseInt(infoVoorstelling[1]);
            int jaar = Integer.parseInt(infoVoorstelling[2]);
            vertoonbaarRepo.voegVoorstellingToe(new Film(naam, sterren, jaar));
        } else
            vertoonbaarRepo.voegVoorstellingToe(new ConcertRegistratie(infoVoorstelling[0], infoVoorstelling[1]));
    }

    public String[] geefAlleVoorstellingen() {
        List<Vertoonbaar> lijst = vertoonbaarRepo.getVoorstellingen();
        String[] resultaat = new String[lijst.size()];
        int index = 0;
        for (Vertoonbaar v : lijst) {
            resultaat[index] = String.format("%s in zaal %d", v.toString(), v.wordtVertoondInZaal());
            index++;
        }
        return resultaat;
    }

    public int geefAantalInZaal(int zaalnr) {
        return vertoonbaarRepo.geefAantalInZaal(zaalnr);
    }
}