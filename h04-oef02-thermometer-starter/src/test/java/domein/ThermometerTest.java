package domein;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ThermometerTest {
    private final static int MIN_TEMP = 14;
    private final static int MAX_TEMP = 104;
    private Thermometer t;

    @BeforeEach
    public void before() {
        t = new Thermometer();
    }

    @Test
    public void maakThermometer_maaktThermometer() {
        assertEquals(32, t.getAantalGraden());
    }

    @ParameterizedTest
    @ValueSource(ints = {MIN_TEMP, MAX_TEMP, 25})
    public void setAantalGraden_geldigeAantalGraden_wijzigtAantalGraden(int aantalGraden) {
        t.setAantalGraden(aantalGraden);
        assertEquals(aantalGraden, t.getAantalGraden());
    }

    @ParameterizedTest
    @ValueSource(ints = {MIN_TEMP - 1, MAX_TEMP + 1, -100, 2800})
    public void setAantalGraden_ongeldigeAantalGraden_werptException(int aantalGraden) {
        assertThrows(IllegalArgumentException.class, () -> t.setAantalGraden(aantalGraden));
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