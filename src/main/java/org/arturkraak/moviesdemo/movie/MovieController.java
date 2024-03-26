package org.arturkraak.moviesdemo.movie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
//@RequestMapping("/api/movies")
public class MovieController {

    public static final int PAGE_LENGHT = 10; // default 10
    public static final int ITEM_LIMIT = 10; // default 10
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

//    @GetMapping("")
//    List<Movie> findall() {
//        return movieRepository.findAll();
//    }

    @GetMapping("/feed")
    public String getFeed(Model model) {
        model.addAttribute("movies", movieRepository.findAll().subList(0, ITEM_LIMIT));
        return "feed";
    }

    @GetMapping("/statuses")
    public String getStatuses(@RequestParam("page")Integer page, Model model) {
        var to = page * PAGE_LENGHT;
        var from = to - PAGE_LENGHT;
        if(page > 99) { // don't go above 50
            return null;
        }
        model.addAttribute("movies",movieRepository.findAll().subList(from, to));
        model.addAttribute("link", "/statuses?page=" + (page+1));
        return "statuses";
    }
}
