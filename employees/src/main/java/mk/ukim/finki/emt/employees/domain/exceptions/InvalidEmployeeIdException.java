package mk.ukim.finki.emt.employees.domain.exceptions;

public class InvalidEmployeeIdException extends RuntimeException {

    public InvalidEmployeeIdException(String message) {
        super(message);
    }
}
