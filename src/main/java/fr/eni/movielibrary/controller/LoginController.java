package fr.eni.movielibrary.controller;

import fr.eni.movielibrary.bll.MemberService;
import fr.eni.movielibrary.bo.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final MemberService memberService;

    @Autowired
    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String loginView(Model model) {
        model.addAttribute("member", new Member());
        return "login";
    }

    @PostMapping("/login")
    public String login(Member member, HttpSession session) {

        // Si les informations du formulaire sont conformes à ce qu'il y a dans le mock
        // le membre est connecté, sinon renvoie vers la page de connexion
        // TODO : On pourrait rajouter un message en cas d'erreur de connexion
        if (member.equals(memberService.findParticipantByUserName(member))) {
            // Logged => on met le membre en session
            session.setAttribute("memberLogged", member);
        } else {
            return "redirect:/login";
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("memberLogged", null);
        return "redirect:/login";
    }
}
