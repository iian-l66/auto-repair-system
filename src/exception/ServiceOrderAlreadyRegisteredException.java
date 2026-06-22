package exception;

public class ServiceOrderAlreadyRegisteredException extends RuntimeException {
    public ServiceOrderAlreadyRegisteredException(String message) {
        super(message);
    }
}
