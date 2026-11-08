package org.telusko.movie_suggestor.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Movie {
    private String title;
    private String description;
    private float[] embedding;
}
