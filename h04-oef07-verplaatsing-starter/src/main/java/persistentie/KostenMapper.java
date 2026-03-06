package persistentie;

import domein.Kosten;
import domein.Ticket;
import domein.VerplaatsingPerAuto;
import domein.VerplaatsingPerBusTram;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KostenMapper {

    public List<Kosten> geefKostenLijst() {
        List<Kosten> deLijst = new ArrayList<>();

        deLijst.add(new VerplaatsingPerBusTram("Voskenslaan Gent", "Veldstraat Gent", 4.2, 1, false, true));
        deLijst.add(new Ticket("Parkeerticket Flanders Expo", 5));
        deLijst.add(new VerplaatsingPerAuto("Gent", "Oudenaarde", 29.4, 1.591, 0.0538));
        deLijst.add(new Ticket("Toegangsticket beurs", 10));
        deLijst.add(new VerplaatsingPerBusTram("Laarne dorp", "Gent Sint-Pieters", 14.6, 34, true, false));
        deLijst.add(new VerplaatsingPerAuto("Gent", "Brussel", 53.7, 1.488, 0.0692));
        deLijst.add(new VerplaatsingPerAuto("Gent", "Kortrijk", 47.1, 1.649, 0.034)); // was 0,034

        // SIMULATIE FOUTIEVE DATA
        // deLijst.add(new VerplaatsingPerAuto("Gent", "Kortrijk", 47.1, 1.649, 1000)); // was 0,034
        // deLijst.add(new VerplaatsingPerAuto("Gent", "Kortrijk", 47.1, -100, 0.034)); // was 0,034
        // deLijst.add(new VerplaatsingPerBusTram("Laarne dorp", "Gent Sint-Pieters", 14.6, -100, true, false));


        // SIMULATIE TECHNISCHE FOUT
        // simuleerTechnischeFout();

        return deLijst;
    }

    private void simuleerTechnischeFout() {
        try {
            throw new SQLException("JDBC encountered an error");
        } catch (SQLException e) {
            throw new IllegalStateException("\nThis is the simulated Database Error: " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}