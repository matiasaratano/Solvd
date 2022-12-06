package homework2.exceptions;

public class CustomNumberFormatException extends NumberFormatException {

    public CustomNumberFormatException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Error: Invalid number format";
    }

}