package domein;

import exceptions.NegativeNumberException;

public class DomeinController {
    private MijnGetal mijnGetal;

    public void startBerekeningVierkantswortel(double getal) throws NegativeNumberException {
        mijnGetal = new MijnGetal(getal);
    }

    public double geefGetal() {
        return mijnGetal.getGetal();
    }

    public double geefVierkantswortel() {
        return mijnGetal.geefVierkantswortel();
    }
}