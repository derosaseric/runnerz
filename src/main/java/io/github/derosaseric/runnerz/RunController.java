package io.github.derosaseric.runnerz;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Run entities.
 *
 * This controller provides endpoints to create, read, update, and delete Run entities.
 */
@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    /**
     * Contructor for the RunController.
     *
     * @param runRepository the repository used for managing Run entities.
     */
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    /**
     * Retrieves all Run entities.
     *
     * @return a list of all Run entities
     */
    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    /**
     * Retrieves a Run entity by its ID.
     *
     * @param id the ID of the Run entity to retrieve
     * @return the Run entity with the specified ID
     * @throws RunNotFoundException if no Run entity with the specified ID is found
     */
    @GetMapping("{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new RunNotFoundException();
        }
        return run.get();
    }

    /**
     * Creates a new Run entity.
     *
     * @param run the Run entity to create
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Run run) {
        runRepository.create(run);
    }

    /**
     * Updates an existing Run entity.
     *
     * @param run the Run entity with updates information
     * @param id the ID of the Run entity to update
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void  update(@Valid @RequestBody Run run, @PathVariable Integer id) {
        runRepository.update(run, id);
    }

    /**
     * Deletes a Run entity by ID.
     *
     * @param id the ID of the Run entity to delete
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        runRepository.delete(id);
    }
}
