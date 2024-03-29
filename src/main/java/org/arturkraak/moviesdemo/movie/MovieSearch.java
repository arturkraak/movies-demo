package org.arturkraak.moviesdemo.movie;

// This class is an object for Thymeleaf. Used in feed.html
public class MovieSearch {
    private String title;


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    private String genre;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
