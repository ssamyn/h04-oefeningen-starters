package domein;

public class DomeinController {
    private Bankrekening rekening;

    public DomeinController() {
        this.rekening = new Bankrekening();
    }

    public void stort(double bedrag) {
        rekening.stort(bedrag);
    }

    public void haalAf(double bedrag) {
        rekening.haalAf(bedrag);
    }

    public double geefSaldo() {
        return rekening.getSaldo();
    }
}