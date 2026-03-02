package ui;

import domein.DomeinController;
import domein.Thermometer;

import java.util.Scanner;

public class ThermometerApplicatie {
    private DomeinController dc;

    public ThermometerApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    public void start() {
        Scanner s = new Scanner(System.in);
        int tempF, tempC;
        boolean invoerOK = false;
        do {
            try {
                System.out.printf("Geef een gehele temperatuur in °F uit het interval [%d, %d]: ",
                        Thermometer.MIN_TEMP, Thermometer.MAX_TEMP);
                tempF = Integer.parseInt(s.nextLine());
                dc.updateTemperatuur(tempF);
                tempC = dc.geefTemperatuurInCelsius();
                System.out.printf("De temperatuur in °C is %d%n", tempC);
                invoerOK = true;
            } catch (NumberFormatException nfe) {
                System.out.println("De invoer moet een geheel getal zijn!");
            }
        }
        while (!invoerOK);
    }
}