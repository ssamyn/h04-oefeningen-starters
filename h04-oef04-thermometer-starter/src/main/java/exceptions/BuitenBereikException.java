package exceptions;

public class BuitenBereikException extends IllegalArgumentException {
    public BuitenBereikException() {
        this("Waarde ligt niet in het gewenste interval!");
    }

    public BuitenBereikException(String msg) {
        super(msg);
    }

    public BuitenBereikException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuitenBereikException(Throwable cause) {
        super(cause);
    }


}