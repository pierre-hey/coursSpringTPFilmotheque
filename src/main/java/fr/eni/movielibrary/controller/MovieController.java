package fr.eni.movielibrary.controller;

import fr.eni.movielibrary.bll.MovieService;
import fr.eni.movielibrary.bo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@Component("movieBean")
@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired // Injection sur le constructeur du controller
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ModelAndView showAllMovies() {
        List<Movie> moviesList = movieService.getAllMovies();

        return new ModelAndView("movie/list", "moviesList", moviesList);
    }

    @GetMapping("/detail")
    public ModelAndView findMovie(@RequestParam(name = "id") long id) {

        Movie movie = movieService.getMovieById(id);

        return new ModelAndView("movie/detail", "movie", movie);
    }


}
