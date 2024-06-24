package io.github.derosaseric.runnerz;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception thrown when a specific run is not found.
 *
 * This exception will trigger a 404 Not Found HTTP status response
 * when it is thrown and not handled.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RunNotFoundException extends RuntimeException {

    /**
     * Constructs a new RunNotFoundException with a default error message.
     */
    public RunNotFoundException() {
        super("Run not found"); // Passes the error message to the superclass constructor
    }
}
