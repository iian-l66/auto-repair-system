package exception;

public class PartAlreadyRegisteredException extends RuntimeException {
    public PartAlreadyRegisteredException(String message) {
        super(message);
    }
}
