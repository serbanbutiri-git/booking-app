# About the app

This application allows users to book flights or hotel rooms from an easy-to-use user interface.
New flights and hotels can be added via APIs, while new users can be created from the user interface.
Because the flights and hotels rarely change these lists are cached for improved performance.

The whole app was created leveraging ChatGPT for defining front end components and routing, APIs, back end services, data model, dependencies,
as well as API tests and Playwright UI tests.

## Tech Stack

- Java 17 (LTS)
- Spring Boot 3.x
- PostgreSQL
- React
- Caffeine Caching
- Docker & Docker Compose

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

- Front end: http://localhost:3000
- Swagger UI: http://localhost:8080/swagger-ui.html
