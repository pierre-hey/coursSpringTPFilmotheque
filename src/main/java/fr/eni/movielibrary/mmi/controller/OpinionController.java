package fr.eni.movielibrary.mmi.controller;

import fr.eni.movielibrary.bll.MovieService;
import fr.eni.movielibrary.bo.Member;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.bo.Opinion;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/opinions")
public class OpinionController {

    private final MovieService movieService;


    public OpinionController(MovieService movieService) {
        this.movieService = movieService;

    }

    @GetMapping("/add")
    public ModelAndView addOpinionMovieView(@RequestParam(name = "id") Integer id,Model model, HttpSession session) {

        if (!ObjectUtils.isEmpty(session.getAttribute("memberLogged"))) {

            Movie movie = movieService.findMovieById(id);
            ModelAndView modelAndView = new ModelAndView("opinion/add");
            modelAndView.addObject(movie);

            return modelAndView;
        } else {
            return new ModelAndView("login", "member", new Member());
        }
    }


    @PostMapping("/add")
    public String addOpinionMovie(@RequestParam(name = "id") Integer id,
                                  @Valid Opinion opinion, BindingResult result,
                                 Model model,
                                 HttpSession session) {
        if (!ObjectUtils.isEmpty(session.getAttribute("memberLogged"))) {
            Member memberLogged = (Member) session.getAttribute("memberLogged");

            Movie movie = movieService.findMovieById(id);
            if (!result.hasErrors()) {

                opinion.setMember(memberLogged);
//              movie.addOpinion(opinion);
//              movieService.updateMovie(movie);
                movieService.saveOpinion(opinion,movie);
                System.out.println("####### Ajout d'un avis #######");
                System.out.println(opinion);
                System.out.println("##############");

                return "redirect:/movies/detail?id=" + id;
            } else {
                model.addAttribute("movie", movie);
                model.addAttribute("opinion", opinion);
                return "/opinion/add";
            }
        } else {
            return "redirect:/login";
        }
    }

}
