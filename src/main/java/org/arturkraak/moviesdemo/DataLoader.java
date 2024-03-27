package org.arturkraak.moviesdemo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.arturkraak.moviesdemo.model.Movie;
import org.arturkraak.moviesdemo.movie.MovieRepository;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DataLoader implements CommandLineRunner {

    private final ObjectMapper objectMapper;
    private final MovieRepository movieRepository;

    public DataLoader(ObjectMapper objectMapper, MovieRepository movieRepository) {
        this.objectMapper = objectMapper;
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Movie> moviesList = new ArrayList<>();
        JsonNode json;

        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/db.json")){
            json = objectMapper.readValue(inputStream, JsonNode.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON data", e);
        }

        JsonNode movies = getMovies(json);
        for(JsonNode movie : movies) {
            System.out.println(movie);
            moviesList.add(createMovieFromNode(movie));
        }

//        System.out.println(moviesList);
        movieRepository.saveAll(moviesList);
    }

    private Movie createMovieFromNode(JsonNode movie) {
        int id = movie.get("id").asInt();
        String title = movie.get("title").asText();
        int releaseYear = Integer.parseInt(movie.get("year").asText());
        int runtime = Integer.parseInt(movie.get("runtime").asText());
        String actors = movie.get("actors").asText();
        String plot = movie.get("plot").asText();
        String posterUrl = movie.get("posterUrl").asText();
        String genres = arrayToCSV(movie, "genres");

        return new Movie(id, title, releaseYear, runtime, genres, actors, plot, posterUrl, null);
    }


    private String arrayToCSV(JsonNode node, String key) {
        JsonNode array = node.get(key);
        StringBuilder sb = new StringBuilder();
        for(JsonNode obj : array) {
            sb.append(obj);
            sb.append(",");
        }
        return sb.toString();
    }

    private JsonNode getMovies(JsonNode json) {
        return Optional.ofNullable(json)
                .map(j -> j.get("movies"))
                .orElseThrow(() -> new IllegalArgumentException("Invalid JSON Object"));
    }
}
