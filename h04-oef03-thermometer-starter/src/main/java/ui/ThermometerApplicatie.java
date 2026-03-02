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
        int tempC;
        boolean invoerOK = false;
        String invoer;

        do {
            try {
                System.out.printf("Geef een gehele temperatuur in °F uit het interval [%d, %d]: ",
                        Thermometer.ONDERGRENS, Thermometer.BOVENGRENS);
                invoer = s.nextLine();

                dc.updateTemperatuur(invoer);
                tempC = dc.geefTemperatuurInCelsius();

                System.out.printf("De temperatuur in °C is %d%n", tempC);
                invoerOK = true;
            } catch (NumberFormatException e) {
                System.out.println("De invoer moet een geheel getal zijn!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (!invoerOK);
    }
}