package domein;

import java.util.List;

public class DomeinController {

    private final VertoonbaarRepository vertoonbaarRepo;

    public DomeinController() {
        vertoonbaarRepo = new VertoonbaarRepository();
    }

    public void voegVoorstellingToe(String naam, int jaar, int sterren) {
        vertoonbaarRepo.voegVoorstellingToe(new Film(naam, sterren, jaar));
    }

    public void voegVoorstellingToe(String artiest, String naam) {
        vertoonbaarRepo.voegVoorstellingToe(new ConcertRegistratie(artiest, naam));
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