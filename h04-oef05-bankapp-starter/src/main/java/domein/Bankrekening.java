package domein;

public class Bankrekening {
    private double saldo;

    public void stort(double bedrag) {
        saldo += bedrag;
    }

    public void haalAf(double bedrag) {
        saldo -= bedrag;
    }

    public double getSaldo() {
        return saldo;
    }
}