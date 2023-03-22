package fr.eni.movielibrary.mmi.controller;

import fr.eni.movielibrary.bll.MovieService;
import fr.eni.movielibrary.bo.Member;
import fr.eni.movielibrary.bo.Movie;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
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
    public ModelAndView showMovieDetailView(@RequestParam(name = "id") long id) {


        Movie movie = movieService.getMovieById(id);

        return new ModelAndView("movie/detail", "movie", movie);
    }

    @GetMapping("/add")
    public ModelAndView addMovieView(HttpSession session) {
        if (!ObjectUtils.isEmpty(session.getAttribute("memberLogged"))) {
            ModelAndView modelAndView = new ModelAndView("movie/add");
            modelAndView.addObject("participantsList", movieService.getParticipants());
            modelAndView.addObject("genreList", movieService.getGenres());

            modelAndView.addObject("movie", new Movie());
            return modelAndView;
        } else {
            return new ModelAndView("login", "member", new Member());
        }
    }

    @PostMapping("/add")
    public String addMovie(@Valid Movie movie, BindingResult result, HttpSession session, Model model) {

        if (!ObjectUtils.isEmpty(session.getAttribute("memberLogged"))) {
            System.out.println("####### Ajout d'un film #######");
            System.out.println(movie);
            System.out.println("##############");

            List<Movie> moviesExist = movieService.getAllMovies();
            List<Integer> idlist = new ArrayList<>();
            moviesExist.forEach(m -> idlist.add(m.getId()));
            Integer lastId = Collections.max(idlist);
            movie.setId(lastId + 1);

            if (!result.hasErrors()) {
                movieService.saveMovie(movie);
            } else {
                result.getAllErrors().forEach(e -> System.out.println(e.getDefaultMessage()));
                model.addAttribute("participantsList", movieService.getParticipants());
                model.addAttribute("genreList", movieService.getGenres());
                model.addAttribute("movie", movie);
                //return "redirect:/movies/add";
                return "movie/add";
            }

        } else {
            System.out.println("Vous n'êtes pas connecté");
            return "redirect:/login";
        }
        return "redirect:/movies";
    }
}
