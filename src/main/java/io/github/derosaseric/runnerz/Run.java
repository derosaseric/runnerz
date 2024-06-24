package io.github.derosaseric.runnerz;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

/**
 * Represents a running activity with details about the run.
 */
public record Run(
    Integer id, // Unique identifier for the run
    @NotEmpty
    String title, // Title or description of the run
    LocalDateTime startedOn, // Timestamp for when the run started
    LocalDateTime completedOn, // Timestamp for when the run was completed
    @Positive
    Integer miles, // Distance of the run in miles
    Location location // Location where the run took place
) {
    /**
     * Validates that completedOn is after startedOn
     *
     * @throws IllegalArgumentException if completedOn is not after startedOn
     */
    public Run {
        if(!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed On must be after Started On");
        }
    }
}
