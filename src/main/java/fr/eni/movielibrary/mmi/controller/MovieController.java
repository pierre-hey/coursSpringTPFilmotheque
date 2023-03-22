package fr.eni.movielibrary.mmi.controller;

import fr.eni.movielibrary.bll.MovieService;
import fr.eni.movielibrary.bo.Movie;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
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

    @GetMapping("/add")
    public ModelAndView addMovieView() {
        System.out.println("MovieController.addMovieView");


        ModelAndView modelAndView = new ModelAndView("movie/add");
        modelAndView.addObject("participantsList", movieService.getParticipants());
        modelAndView.addObject("genreList", movieService.getGenres());

        modelAndView.addObject("movie", new Movie());
        return modelAndView;
    }

    @PostMapping("/add")
    public String addMovie(Movie movie, HttpSession session) {
        List<Movie> moviesExist = movieService.getAllMovies();

        List<Integer> idlist = new ArrayList<>();
        moviesExist.forEach(m -> idlist.add(m.getId()));

        Integer lastId = Collections.max(idlist);

        movie.setId(lastId + 1);
        System.out.println("##############");
        System.out.println(movie);
        System.out.println("##############");

        if (!ObjectUtils.isEmpty(session.getAttribute("memberLogged"))) {
            movieService.saveMovie(movie);
        }
        return "redirect:/movies";
    }
}
