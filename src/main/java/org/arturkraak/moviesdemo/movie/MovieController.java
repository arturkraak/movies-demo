package org.arturkraak.moviesdemo.movie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cinema/")
public class MovieController {

    public static final int PAGE_LENGTH = 10; // default 10
    public static final int ITEM_LIMIT = 10; // default 10
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("")
    public String getFeed(Model model) {
        model.addAttribute("movies", movieRepository.findAll().subList(0, ITEM_LIMIT));
        model.addAttribute("movieSearch", new MovieSearch());
        System.out.println(MovieConfig.getGenres());
        model.addAttribute("genres", MovieConfig.getGenres());
        return "feed";
    }

    @GetMapping("/movie")
    public String getTitle(@RequestParam String title,
                           @RequestParam(required = false) String genre,
                           Model model) {
//        model.addAttribute("movies", movieRepository.findAll().subList(0, ITEM_LIMIT));
        List<Movie> movies = movieRepository.findMovieByGenre(title, genre);
        System.out.println("### "+ movies);
        model.addAttribute("movies", movies);
        System.out.println(MovieConfig.getGenres());
        model.addAttribute("movieSearch", new MovieSearch());
        model.addAttribute("genres", MovieConfig.getGenres());
        return "feed";
    }


    @GetMapping("/statuses")
    public String getStatuses(@RequestParam("page") Integer page, Model model) {
        var to = page * PAGE_LENGTH;
        var from = to - PAGE_LENGTH;
        if(page > 99) { // don't go above 50
            return null;
        }
        model.addAttribute("movies",movieRepository.findAll().subList(from, to));
        model.addAttribute("link", "/statuses?page=" + (page+1));
        return "statuses";
    }
}
