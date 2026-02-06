# Getting Started

This application allows users to book flights or hotel rooms.

## Tech Stack

- Java 17 (LTS)
- Spring Boot 3.x
- PostgreSQL
- Docker & Docker Compose

## Getting Started

Build the project:

```bash
  mvn -N io.takari:maven:wrapper
```

```bash
  ./mvnw clean package -DskipTests
```

```bash
  docker-compose up --build
```

The application along with a description of the API endpoints will be available at http://localhost:8080/swagger-ui.html

