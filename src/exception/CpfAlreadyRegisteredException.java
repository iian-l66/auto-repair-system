package exception;

public class CpfAlreadyRegisteredException extends RuntimeException {
    public CpfAlreadyRegisteredException(String message) {
        super(message);
    }
}
