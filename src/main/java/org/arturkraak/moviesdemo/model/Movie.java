package org.arturkraak.moviesdemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;


public record Movie(
        @Id
        int id,
        String title,
        int releaseYear,
        int runtime,
        String genres,
        String actors,
        String plot,
        String posterUrl,
        @Version
        Integer version
) {
       
}
