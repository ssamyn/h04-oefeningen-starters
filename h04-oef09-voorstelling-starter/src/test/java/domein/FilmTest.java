package domein;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FilmTest {
    private final static int HUIDIG_JAAR = LocalDate.now().getYear();
    private static final int MIN_STERREN = 0;
    private static final int MAX_STERREN = 5;
    private static final int MIN_JAAR = 1900;

    @Test
    void maakFilm_alleGegevensOk_maaktFilm() {
        String naam = "test";
        int jaar = 2005;
        int sterren = 4;

        Film f = new Film(naam, sterren, jaar);

        Assertions.assertEquals(naam, f.getNaam());
        Assertions.assertEquals(sterren, f.getSterren());
        Assertions.assertEquals(jaar, f.getJaar());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "         ", "\t\t", "\n"})
    void maakFilm_legeNaam_werptException(String naam) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Film(naam, 3, 2018));
    }

    @ParameterizedTest
    @ValueSource(ints = {MIN_STERREN - 1, MAX_STERREN + 1, -10, 1000})
    void maakFilm_aantalSterrenTeKleinOfTeGroot_werptException(int sterren) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Film("test", sterren, 2018));
    }

    @ParameterizedTest
    @ValueSource(ints = {MIN_STERREN, MAX_STERREN})
    void maakFilm_aantalSterrenGrenswaarde_maaktFilm(int sterren) {
        Assertions.assertDoesNotThrow(() -> new Film("test", sterren, 2018));
    }

    @ParameterizedTest
    @ValueSource(ints = {MIN_JAAR - 1, MIN_JAAR - 10})
    void maakFilm_jaarTeKleinOfTeGroot_werptException(int jaar) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Film("test", 3, jaar));
    }

    @Test
    void maakFilm_jaarNetTeGroot_werptException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Film("test", 3, HUIDIG_JAAR + 1));
    }

    @Test
    void maakFilm_jaarTeGroot_werptException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Film("test", 3, HUIDIG_JAAR + 10));
    }

    @ParameterizedTest
    @ValueSource(ints = {MIN_JAAR, 2022})
    void maakFilm_jaarGrenswaarde_maaktFilm(int jaar) {
        Assertions.assertDoesNotThrow(() -> new Film("test", 3, jaar));
    }

    @Test
    void equals_naamEnJaarGelijk_returnsTrue() {
        Film f1 = new Film("naam", 3, 2018);
        Film f2 = new Film("naam", 1, 2018);
        assertEquals(f1, f2);
    }

    @Test
    void equals_naamEnSterrenGelijk_returnsFalse() {
        Film f1 = new Film("naam", 1, 2018);
        Film f2 = new Film("naam", 1, 2016);
        assertNotEquals(f1, f2);
    }

    @Test
    void equals_jaarEnSterrenGelijk_returnsFalse() {
        Film f1 = new Film("naam1", 1, 2018);
        Film f2 = new Film("naam2", 1, 2018);
        assertNotEquals(f1, f2);
    }
}