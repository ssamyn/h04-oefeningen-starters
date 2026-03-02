package domein;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ThermometerTest {
    private Thermometer t;

    @BeforeEach
    public void before() {
        t = new Thermometer();
    }

    @Test
    public void maakThermometer_maaktThermometer() {
        assertEquals(32, t.getAantalGraden());
    }

    @Test
    public void setAantalGraden_wijzigtAantalGraden() {
        t.setAantalGraden(80);
        assertEquals(80, t.getAantalGraden());
    }

    @Test
    public void converteerNaarCelsius_afrondenNaarBeneden_converteertNaarCelcius() {
        t.setAantalGraden(52);
        int conversie = t.converteerNaarCelsius();
        assertEquals(11, conversie);
    }

    @Test
    public void converteerNaarCelsius_afrondenNaarBoven_converteertNaarCelcius() {
        t.setAantalGraden(55);
        int conversie = t.converteerNaarCelsius();
        assertEquals(13, conversie);
    }
}