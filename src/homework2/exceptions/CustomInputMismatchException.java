package homework2.exceptions;

import java.util.InputMismatchException;

public class CustomInputMismatchException extends RuntimeException {
    public CustomInputMismatchException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Error: Invalid input value. ";
    }
}
