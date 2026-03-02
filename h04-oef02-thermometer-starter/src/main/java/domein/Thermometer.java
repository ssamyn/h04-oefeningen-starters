package domein;

public class Thermometer {
    private int aantalGraden;
    public static final int MIN_TEMP = 14, MAX_TEMP = 104;

    public Thermometer() {
        setAantalGraden(32);
    }

    public int getAantalGraden() {
        return aantalGraden;
    }

    public void setAantalGraden(int aantalGraden) {
        this.aantalGraden = aantalGraden;
    }

    public int converteerNaarCelsius() {
        return (int) Math.round((aantalGraden - 32) * 5 / 9.0);
    }
}