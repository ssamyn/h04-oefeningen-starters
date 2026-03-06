package domein;

import exceptions.LegeStringException;
import persistentie.VertoonbaarMapper;

import java.util.List;

public class VertoonbaarRepository {
    private final VertoonbaarMapper vm;
    private List<Vertoonbaar> voorstellingen;

    public VertoonbaarRepository() throws LegeStringException {
        vm = new VertoonbaarMapper();
        voorstellingen = vm.geefAlleVoorstellingen();
    }

    public void voegVoorstellingToe(Vertoonbaar v) {
        if (!voorstellingen.contains(v))
            voorstellingen.add(v);
    }

    public List<Vertoonbaar> getVoorstellingen() {
        return voorstellingen;
    }

    public int geefAantalInZaal(int zaalnr) {
        int aantal = 0;

        for (Vertoonbaar v : voorstellingen)
            if (v.wordtVertoondInZaal() == zaalnr)
                aantal++;

        return aantal;
    }
}