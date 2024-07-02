# runnerz

runnerz is a web application designed to manage and track running activities. It provides a RESTful API to create, read, update, and delete run records.

## Work in Progress

This project is currently under active development. Features and functionality may change as the project evolves.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- Create, read, update, and delete run records.
- In-memory database using H2 for development and testing.
- Input validation for run details.
- Predefined run data for testing.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/derosaseric/runnerz.git
   cd runnerz
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
## Dependencies

The following dependencies are used in this project:

- Spring Boot Starter Web
- Spring Boot Starter JDBC
- Spring Boot Starter Validation
- H2 Database

## Usage

### API Endpoints

- `GET /api/runs` - Retrieve all runs.
- `GET /api/runs/{id}` - Retrieve a run by ID.
- `POST /api/runs` - Create a new run.
- `PUT /api/runs/{id}` - Update an existing run.
- `DELETE /api/runs/{id}` - Delete a run.

### Example Run Record

```json
{
  "id": 1,
  "title": "Morning Run",
  "startedOn": "2024-06-01T07:00:00",
  "completedOn": "2024-06-01T07:30:00",
  "miles": 3,
  "location": "OUTDOOR"
}
```

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
