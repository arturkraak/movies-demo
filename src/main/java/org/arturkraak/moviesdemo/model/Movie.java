package org.arturkraak.moviesdemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;


public record Movie(
        @Id
        int id,
        String title,
        String releaseYear,
        String runtime,
        String genres,
        String actors,
        String plot,
        String posterUrl,
        @Version
        Integer version
) {
        @Override
        public int id() {
                return id;
        }

        @Override
        public String title() {
                return title;
        }

        @Override
        public String runtime() {
                return runtime;
        }

        @Override
        public String actors() {
                return actors;
        }

        @Override
        public String plot() {
                return plot;
        }

        @Override
        public String posterUrl() {
                return posterUrl;
        }

        @Override
        public String genres() {
                return genres;
        }

        @Override
        public Integer version() {
                return version;
        }
}
