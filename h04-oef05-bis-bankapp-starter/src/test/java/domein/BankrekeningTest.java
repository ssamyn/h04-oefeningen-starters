package domein;

import exceptions.SaldoTeLaagException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BankrekeningTest {

    private Bankrekening rekening;

    @BeforeEach
    public void setUp() {
        rekening = new Bankrekening();
    }

    // --- TESTEN VOOR STORTEN ---

    @Test
    public void stort_GeldigBedrag_VerhoogtSaldo() {
        rekening.stort(100.0);
        Assertions.assertEquals(100.0, rekening.getSaldo(), 0.01);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -0.01, -100.0})
    public void stort_OngeldigBedrag_WerptIllegalArgumentException(double bedrag) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> rekening.stort(bedrag));
    }

    // --- TESTEN VOOR AFHALEN ---

    @Test
    public void haalAf_GeldigBedragBinnenSaldo_VerlaagtSaldo() throws SaldoTeLaagException {
        rekening.stort(100.0);
        rekening.haalAf(40.0);
        Assertions.assertEquals(60.0, rekening.getSaldo(), 0.01);
    }

    @Test
    public void haalAf_BedragGelijkAanSaldo_SaldoWordtNul() throws SaldoTeLaagException {
        rekening.stort(100.0);
        rekening.haalAf(100.0);
        Assertions.assertEquals(0.0, rekening.getSaldo(), 0.01);
    }

    @Test
    public void haalAf_BedragGroterDanSaldo_WerptSaldoTeLaagException() {
        rekening.stort(50.0);
        Assertions.assertThrows(SaldoTeLaagException.class, () -> rekening.haalAf(50.01));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.0})
    public void haalAf_OngeldigBedrag_WerptIllegalArgumentException(double bedrag) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> rekening.haalAf(bedrag));
    }
}