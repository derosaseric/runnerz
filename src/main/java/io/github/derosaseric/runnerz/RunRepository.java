package io.github.derosaseric.runnerz;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repository class for managing Run entities.
 *
 * This class simulates a database using an in-memory list to store Run entities.
 * It provides methods for CRUD operations on Run entities.
 */
@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    /**
     * Retrieves all Run entites.
     *
     * @return a list of all Run entities
     */
    List<Run> findAll() {
        return runs;
    }

    /**
     * Retrieves a Run entity by its ID.
     *
     * @param id the ID of the Run entity to retrieve
     * @return an Optional containing the Run entity if found, or empty if not found
     */
    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    /**
     * Create a new Run entity.
     *
     * @param run the Run entity to create
     */
    void create(Run run) {
        runs.add(run);
    }

    /**
     * Updates an existing Run entity.
     *
     * @param run the Run entity with updates information
     * @param id the ID of the Run entity to update
     */
    void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    /**
     * Deletes a Run entity by its ID.
     *
     * @param id the ID of the Run entity to delete
     */
    void delete (Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    /**
     * Initializes the repository with some default Run entities.
     *
     * This method is called after the bean is constructed to populate the repository
     * with initial data.
     */
    @PostConstruct
    private void init() {
        runs.add(new Run(1,
                "Monday Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                3,
                Location.INDOOR));

        runs.add(new Run(2,
                "Wednesday Evening Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(60, ChronoUnit.MINUTES),
                6,
                Location.INDOOR));
    }
}
