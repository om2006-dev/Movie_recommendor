package org.telusko.movie_suggestor.embedding_config;

import dev.langchain4j.model.embedding.EmbeddingModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class EmbeddingTest {

    @Bean
    CommandLineRunner run(EmbeddingModel model) {
        return args -> {
            float[] v = model.embed("A space adventure about friendship").content().vector();
            System.out.println("Vector size: " + v.length); // should print 384
        };
    }
}