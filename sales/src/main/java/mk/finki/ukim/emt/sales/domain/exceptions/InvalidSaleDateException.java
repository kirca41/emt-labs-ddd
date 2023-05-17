package mk.finki.ukim.emt.sales.domain.exceptions;

public class InvalidSaleDateException extends RuntimeException {

    public InvalidSaleDateException(String message) {
        super(message);
    }
}
