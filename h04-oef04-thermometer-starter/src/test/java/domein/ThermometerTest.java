package domein;

import exceptions.BuitenBereikException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
    public void setAantalGraden_aantalGradenNetGrootGenoeg_wijzigtAantalGraden() {
        t.stelAantalGradenIn("14");
        assertEquals(14, t.getAantalGraden());
    }

    @Test
    public void setAantalGraden_aantalGradenGeldig_wijzigtAantalGraden() {
        t.stelAantalGradenIn("88");
        assertEquals(88, t.getAantalGraden());
    }

    @Test
    public void setAantalGraden_aantalGradenGrootstMogelijk_wijzigtAantalGraden() {
        t.stelAantalGradenIn("104");
        assertEquals(104, t.getAantalGraden());
    }

    @ParameterizedTest
    @ValueSource(strings = {"13", "-88", "105", "2567"})
    public void stelAantalGradenIn_ongeldigeAantalGraden_werptException(String aantalGraden) {
        assertThrows(BuitenBereikException.class, () -> t.stelAantalGradenIn(aantalGraden));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"    ", "ABCD", "22,2", "22.2"})
    public void stelAantalGradenIn_aantalGradenGeenGeheelGetal_werptException(String aantalGraden) {
        assertThrows(NumberFormatException.class, () -> t.stelAantalGradenIn(aantalGraden));
    }

    @Test
    public void converteerNaarCelsius_afrondenNaarBeneden_converteertNaarCelcius() {
        t.stelAantalGradenIn("52");
        int conversie = t.converteerNaarCelsius();
        assertEquals(11, conversie);
    }

    @Test
    public void converteerNaarCelsius_afrondenNaarBoven_converteertNaarCelcius() {
        t.stelAantalGradenIn("55");
        int conversie = t.converteerNaarCelsius();
        assertEquals(13, conversie);
    }
}