# Getting Started

This application allows users to book flights or hotel rooms.

## Tech Stack

- Java 17 (LTS)
- Spring Boot 3.x
- PostgreSQL
- Docker & Docker Compose
- Caffeine for caching
- React front end

## Getting Started

Build the project:

```bash
  mvn -N io.takari:maven:wrapper
```

```bash
   cd backend
  ./mvnw clean package -DskipTests
```

```bash
  docker-compose up --build
```

To access the application go to:
Front end: http://localhost:3000
Swagger UI: http://localhost:8080/swagger-ui.html
