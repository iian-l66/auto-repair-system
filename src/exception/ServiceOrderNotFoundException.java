package exception;

public class ServiceOrderNotFoundException extends EntityNotFoundException {
    public ServiceOrderNotFoundException(String message) {
        super(message);
    }
}
