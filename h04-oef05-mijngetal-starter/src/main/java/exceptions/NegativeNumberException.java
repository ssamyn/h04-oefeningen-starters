package exceptions;

public class NegativeNumberException extends Exception {
    
    public NegativeNumberException() {
        this("Getal mag niet negatief zijn!");
    }

    public NegativeNumberException(String msg) {
        super(msg);
    }
}