package exception;

public class VendingException extends Exception {
    public VendingException(String message, Throwable e) {
        super(message, e);
    }

    public VendingException(String message) {
        super(message);
    }
    
}
