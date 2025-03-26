package sia.validation;

public class ToLowValueException extends Exception{

    public ToLowValueException() {
    }

    public ToLowValueException(String message) {
        super(message);
    }

    public ToLowValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public ToLowValueException(Throwable cause) {
        super(cause);
    }

    public ToLowValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
