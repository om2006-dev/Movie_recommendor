# Movie Suggestor

A Spring Boot Java application that recommends movies based on semantic similarity using embeddings from Ollama.

## Overview

This project loads a movie dataset from `src/main/resources/movies.json`, generates embeddings for each movie description using the `nomic-embed-text` model via LangChain4j, and then compares user queries against those embeddings to find the most relevant movies.

It exposes a small REST API for:
- searching movies by natural-language query
- finding movies similar to a selected movie title

## Features

- Java 17 + Spring Boot 4
- Movie recommendation based on embedding similarity
- Ollama-backed embedding model
- REST endpoints for query/search operations
- Maven wrapper included for easy startup

## Tech Stack

- Java 17
- Spring Boot 4.1.2
- Maven
- LangChain4j
- Ollama (`nomic-embed-text`)

## Project Structure

```text
Movie_recommendor/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/telusko/movie_suggestor/
│   │   │       ├── controllers/
│   │   │       ├── embedding_config/
│   │   │       ├── model/
│   │   │       ├── services/
│   │   │       └── MovieSuggestorApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── movies.json
│   └── test/
├── .gitignore
├── .gitattributes
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Prerequisites

Before running the project, make sure you have:

- Java 17 or newer
- Maven (or use the included `./mvnw` wrapper)
- Ollama installed and running locally
- The `nomic-embed-text` model pulled in Ollama

### Install and run Ollama

```bash
ollama pull nomic-embed-text
ollama serve
```

The app is configured to connect to:

```text
http://localhost:11434
```

## Configuration

The app configuration is in:

```properties
src/main/resources/application.properties
```

Current configuration:

```properties
spring.application.name=Movie_Suggestor
```

The embedding model is configured in:

```java
src/main/java/org/telusko/movie_suggestor/embedding_config/EmbeddingConfig.java
```

It uses:

```java
OllamaEmbeddingModel.builder()
    .baseUrl("http://localhost:11434")
    .modelName("nomic-embed-text")
    .build();
```

## Run the Application

Using Maven wrapper:

```bash
./mvnw spring-boot:run
```

Or with Maven:

```bash
mvn spring-boot:run
```

The application should start on the default Spring Boot port:

```text
http://localhost:8080
```

## API Endpoints

### 1) Search for movies by query

Endpoint:

```http
POST /api/search?query={your_query}
```

Example:

```bash
curl -X POST "http://localhost:8080/api/search?query=funny family movie"
```

### 2) Find similar movies

Endpoint:

```http
POST /api/similarMovie?query={movie_title}
```

Example:

```bash
curl -X POST "http://localhost:8080/api/similarMovie?query=Inception"
```

## How Recommendation Works

1. The app loads movie descriptions from `movies.json`.
2. Each movie description is converted to an embedding using Ollama.
3. A user query is also converted into an embedding.
4. The application computes cosine similarity between the query embedding and each movie embedding.
5. The best-matching movies are ranked and returned.

## Notes

- The dataset is stored in `src/main/resources/movies.json`.
- The recommendation logic is implemented in `MovieService.java`.
- The controller layer exposes the API via `Endpoints.java`.
- This project is a good example of combining Spring Boot with local AI embeddings and semantic search.

## License

This project does not currently declare a license in the repository metadata. Add one if you plan to publish or share it publicly.

## Author

Created for a movie recommendation application using Spring Boot and Ollama embeddings.
