package ui;

import java.util.Scanner;

public class IO {
    public static final String FOUT_PREFIX = "🔴 ";
    public static final Scanner INVOER = new Scanner(System.in);

    public static double geefDecimaalGetal(String vraag, double min) {
        return geefDecimaalGetal(vraag, min, Double.MAX_VALUE);
    }

    public static double geefDecimaalGetal(String vraag, double min, double max) {
        double waarde = 0;
        boolean invoerOK = false;
        do {
            try {
                System.out.print(vraag + " > ");
                // Invoer met decimale komma en decimale punt worden beide toegestaan:
                // Spaties voor of na de invoer worden genegeerd
                String input = INVOER.nextLine().replace(',', '.').trim();
                waarde = Double.parseDouble(input);
                invoerOK = waarde >= min && waarde <= max;
                if (!invoerOK)
                    if (max == Double.MAX_VALUE) {
                        System.out.printf("%sVoer een waarde in die minstens %.2f is.%n%n", FOUT_PREFIX, min);
                    } else {
                        System.out.printf("%sVoer een waarde in tussen %.2f en %.2f.%n%n", FOUT_PREFIX, min, max);
                    }
            } catch (NumberFormatException e) {
                System.out.printf("%sDit is geen geldig getal. Probeer opnieuw.%n%n", FOUT_PREFIX);
            }
        } while (!invoerOK);
        return waarde;
    }

    public static int geefGeheelGetal(String vraag, int min, int max) {
        int waarde = 0;
        boolean invoerOK = false;
        do {
            try {
                System.out.print(vraag + " > ");
                waarde = Integer.parseInt(INVOER.nextLine().trim());
                invoerOK = waarde >= min && waarde <= max;
                if (!invoerOK) {
                    System.out.printf("%sVoer een waarde in tussen %d en %d.%n%n", FOUT_PREFIX, min, max);
                }
            } catch (NumberFormatException e) {
                System.out.printf("%sDit is geen geldig geheel getal. Probeer opnieuw.%n%n", FOUT_PREFIX);
            }
        } while (!invoerOK);
        return waarde;
    }

    public static int geefStriktPositiefGeheelGetal(String vraag) {
        return geefEenPositiefGeheelGetal(vraag, true);
    }

    public static int geefPositiefGeheelGetal(String vraag) {
        return geefEenPositiefGeheelGetal(vraag, false);
    }

    private static int geefEenPositiefGeheelGetal(String vraag, boolean strikt) {
        int waarde = 0;
        boolean invoerOK = false;
        do {
            try {
                System.out.print(vraag + " > ");
                waarde = Integer.parseInt(INVOER.nextLine().trim());
                invoerOK = strikt ? waarde > 0 : waarde >= 0;
                if (!invoerOK) {
                    System.out.printf("%sVoer een %spositieve waarde in.%n%n", FOUT_PREFIX, strikt ? "strikt " : "");
                }
            } catch (NumberFormatException e) {
                System.out.printf("%sDit is geen geldig geheel getal. Probeer opnieuw.%n%n", FOUT_PREFIX);
            }
        } while (!invoerOK);
        return waarde;
    }

    public static String geefEenNietLegeString(String vraag) {
        String waarde;
        boolean invoerOK;
        do {
            System.out.print(vraag + " > ");
            waarde = INVOER.nextLine().trim();
            invoerOK = !waarde.isBlank();
            if (!invoerOK) {
                System.out.printf("%sJe moet een waarde opgeven.%n%n", FOUT_PREFIX);
            }
        } while (!invoerOK);
        return waarde;
    }

    public static boolean geefJaNeeAntwoord(String vraag) {
        String waarde;
        boolean invoerOK;
        do {
            System.out.print(vraag + " > ");
            waarde = INVOER.nextLine().trim();
            invoerOK = waarde.equalsIgnoreCase("ja") || waarde.equalsIgnoreCase("nee");
            if (!invoerOK) {
                System.out.printf("%sJe moet antwoorden met 'ja' of 'nee'.%n%n", FOUT_PREFIX);
            }
        } while (!invoerOK);
        return waarde.equalsIgnoreCase("ja");
    }
}