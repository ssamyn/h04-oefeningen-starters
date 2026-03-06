package domein;

public class Gebouw implements Draagbaar {
    private final String naam;
    private double hoogte;

    public Gebouw(String naam, double hoogte) {
        super();
        this.naam = naam;
        this.setHoogte(hoogte);
    }

    public String getNaam() {
        return naam;
    }

    public double getHoogte() {
        return hoogte;
    }

    public final void setHoogte(double hoogte) {
        if (hoogte < 3)
            throw new IllegalArgumentException("de hoogte moet minstens 3m zijn!");
        this.hoogte = hoogte;
    }

    @Override
    public boolean isDraagbaar() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s Gebouw '%s' met hoogte %.1f.", isDraagbaar() ? "Draagbaar:" : "Niet draagbaar:", naam, hoogte);
    }

}