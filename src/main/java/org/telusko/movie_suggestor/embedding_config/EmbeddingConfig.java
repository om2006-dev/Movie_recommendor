package org.telusko.movie_suggestor.embedding_config;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.ollama.OllamaEmbeddingModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddingConfig {

    EmbeddingConfig()
    {
        System.out.println("called");
    }
        @Bean
        public EmbeddingModel embeddingModel() {
            return OllamaEmbeddingModel.builder()
                    .baseUrl("http://localhost:11434")
                    .modelName("nomic-embed-text")
                    .build();
        }
    }

