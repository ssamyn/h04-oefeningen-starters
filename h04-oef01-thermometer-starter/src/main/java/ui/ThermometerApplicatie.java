package ui;

import domein.DomeinController;

import java.util.Scanner;

public class ThermometerApplicatie {
    private final DomeinController dc;

    public ThermometerApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    public void start() {
        final int lowest = 14;
        final int highest = 104;
        Scanner s = new Scanner(System.in);
        int tempF, tempC;

        System.out.printf("Geef een gehele temperatuur in °F uit het interval [%d, %d]: ", lowest, highest);
        tempF = Integer.parseInt(s.nextLine());
        dc.updateTemperatuur(tempF);
        tempC = dc.geefTemperatuurInCelsius();
        System.out.printf("De temperatuur in °C is %d%n", tempC);
    }
}