package mk.ukim.finki.emt.products.domain.exceptions;

public class InvalidProductIdException extends RuntimeException {

    public InvalidProductIdException(String message) {
        super(message);
    }
}
