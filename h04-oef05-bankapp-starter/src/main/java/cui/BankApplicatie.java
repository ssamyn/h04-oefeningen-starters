package cui;

import domein.DomeinController;

import java.util.Scanner;

public class BankApplicatie {
    private final DomeinController dc;

    public BankApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    public void start() {
        Scanner s = new Scanner(System.in);
        boolean stop = false;

        System.out.println("--- HOGENT Bank ---");

        do {
            System.out.printf("%nHuidig saldo: %.2f EUR%n", dc.geefSaldo());
            System.out.print("Geef transactie (s of a) en bedrag gescheiden door een spatie (bv. 's 50.0' of 'a 12.5') of 'stop': ");
            String invoer = s.nextLine();

            if (invoer.equalsIgnoreCase("stop")) {
                stop = true;
            } else {
                // TODO - splitsen van de invoer en variabelen actie en bedrag waarde geven

                String actie = null;
                double bedrag = 0;

                switch (actie) {
                    case "s" -> doeStorting(bedrag);
                    case "a" -> doeAfhaling(bedrag);
                    default ->
                            System.out.println("Ongeldige transactie. Gebruik 's' voor storten, of 'a' voor afhalen.");
                }
            }
        } while (!stop);
        System.out.println("\nBankapplicatie wordt afgesloten, tot een volgende keer...");
    }

    private void doeStorting(double bedrag) {
        dc.stort(bedrag);
        System.out.println("Transactie succesvol: bedrag gestort.");
    }

    private void doeAfhaling(double bedrag) {
        dc.haalAf(bedrag);
        System.out.println("Transactie succesvol: bedrag afgehaald.");
    }
}