package exceptions;

public class LegeStringException extends Exception {
    public LegeStringException() {
        this("Alle velden zijn verplicht!");
    }

    public LegeStringException(String message) {
        super(message);
    }
}