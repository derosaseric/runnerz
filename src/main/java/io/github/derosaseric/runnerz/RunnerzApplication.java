package io.github.derosaseric.runnerz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class RunnerzApplication {

	// Initializing a logger for the RunnerzApplication class
	private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		// Define a CommandLineRunner bean that executes code after the application context is loaded
		return args -> {
			// Create a new instance of Run with specified attributes
			// Parameters: id, name, start time, end time , distance, location
			Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);

			// Log the details of the created Run instance
			log.info("Run: " + run);
		};
	}
}
