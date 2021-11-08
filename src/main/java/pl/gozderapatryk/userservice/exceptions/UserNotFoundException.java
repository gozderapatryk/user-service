package pl.gozderapatryk.userservice.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
