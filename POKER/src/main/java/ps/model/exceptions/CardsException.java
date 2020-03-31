package ps.model.exceptions;

public class CardsException extends RuntimeException{
    public CardsException() {
    }

    public CardsException(String message) {
        super(message);
    }

    public CardsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardsException(Throwable cause) {
        super(cause);
    }

    public CardsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
