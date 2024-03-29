package org.arturkraak.moviesdemo.movie;

import jakarta.persistence.*;

@Entity
@Table
public class Movie {
    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )

    private int id;
    private String title;
    private int releaseYear;
    private int runtime;
    private String genres;
    private String actors;
    @Column(name = "plot", length = 1024)
    private String plot;
    @Column(name = "poster_url", length = 1024)
    private String posterUrl;

    public Movie(int id, String title, int releaseYear, int runtime, String genres, String actors, String plot, String posterUrl) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.runtime = runtime;
        this.genres = genres;
        this.actors = actors;
        this.plot = plot;
        this.posterUrl = posterUrl;
    }

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

}
