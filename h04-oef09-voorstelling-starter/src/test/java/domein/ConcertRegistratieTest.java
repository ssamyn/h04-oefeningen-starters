package domein;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ConcertRegistratieTest {
    private ConcertRegistratie cr;
    private static final String GELDIGE_ARTIEST = "Taylor Swift";
    private static final String GELDIGE_NAAM = "Taylor's version - The Las Vegas Show - december 2021";

    @BeforeEach
    public void setUp() {
        cr = new ConcertRegistratie(GELDIGE_ARTIEST, GELDIGE_NAAM);
    }

    @Test
    public void maakConcertRegistratie_alleGegevensGeldig_maaktConcertRegistratie() {
        Assertions.assertEquals(GELDIGE_ARTIEST, cr.getArtiest());
        Assertions.assertEquals(GELDIGE_NAAM, cr.getConcertNaam());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t\t", "\n", "\n  \t \t  \n"})
    public void maakConcertRegistratie_ongeldigeArtiest_werptException(String artiest) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ConcertRegistratie(artiest, GELDIGE_NAAM));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t\t", "\n", "\n  \t \t  \n"})
    public void maakConcertRegistratie_ongeldigeConcertNaam_werptException(String concertNaam) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ConcertRegistratie(GELDIGE_ARTIEST, concertNaam));
    }
}