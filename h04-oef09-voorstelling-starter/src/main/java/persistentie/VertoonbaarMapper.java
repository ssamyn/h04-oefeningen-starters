package persistentie;

import domein.ConcertRegistratie;
import domein.Film;
import domein.Vertoonbaar;
import exceptions.LegeStringException;

import java.util.ArrayList;
import java.util.List;

public class VertoonbaarMapper {

    public List<Vertoonbaar> geefAlleVoorstellingen() throws LegeStringException {

        List<Vertoonbaar> voorstellingen = new ArrayList<>();

        voorstellingen.add(new Film("film A", 5, 2020));
        voorstellingen.add(new ConcertRegistratie("artiest 1", "concert 1"));
        voorstellingen.add(new ConcertRegistratie("artiest 2", "concert 2"));
        voorstellingen.add(new Film("film B", 3, 2018));
        // voorstellingen.add(new Film("", 5, 2020));
        // voorstellingen.add(new ConcertRegistratie("", "concert 1"));
        // voorstellingen.add(new Film("film B", 1000, 2018));

        return voorstellingen;
    }
}