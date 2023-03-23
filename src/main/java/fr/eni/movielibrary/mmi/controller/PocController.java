package fr.eni.movielibrary.mmi.controller;

import fr.eni.movielibrary.bll.MemberService;
import fr.eni.movielibrary.bo.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hobbies")
public class PocController {


    private final MemberService memberService;
    List<String> hobbiesList;
    @Autowired
    public PocController(MemberService memberService) {
        this.memberService = memberService;
        hobbiesList = List.of("Sport", "Cinema", "Musique");
    }

    @GetMapping
    public ModelAndView pocHobbyView(HttpSession session) {
        Member memberLogged = (Member) session.getAttribute("memberLogged");
        if (!ObjectUtils.isEmpty(memberLogged)) {
            ModelAndView modelAndView = new ModelAndView("pocHobby", "member", memberService.findMemberByLogin(memberLogged.getLogin()));
            modelAndView.addObject("hobbiesList", hobbiesList);

            return modelAndView;
        }
        return new ModelAndView("login", "member", new Member());
    }

    @PostMapping("/add")
    public String pocHobby(Member member, HttpSession session) {

        Member memberLogged = (Member) session.getAttribute("memberLogged");
        member.setId(memberLogged.getId());

        // MAJ du membre en bdd et de l'attribut en session
        memberService.updateMember(member);
        session.setAttribute("memberLogged",member);

        return ("redirect:/hobbies");

    }

}
