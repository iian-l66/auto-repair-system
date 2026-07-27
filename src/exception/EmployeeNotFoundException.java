package exception;

public class EmployeeNotFoundException extends EntityNotFoundException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
