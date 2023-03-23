package fr.eni.movielibrary.mmi.controller;

import fr.eni.movielibrary.bll.MemberService;
import fr.eni.movielibrary.bo.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hobbies")
public class pocController {


    private final MemberService memberService;

    @Autowired
    public pocController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ModelAndView pocHobbyView(HttpSession session) {
        List<String> hobbiesList = List.of("Sport", "Cinema", "Musique");
        Member memberLogged = (Member) session.getAttribute("memberLogged");

        ModelAndView modelAndView = new ModelAndView("pocHobby", "memberLogged", memberLogged);
        modelAndView.addObject("hobbiesList", hobbiesList);

        return modelAndView;
    }

    @PostMapping("/add")
    public String pocHobby(Member member, HttpSession session) {


        Member memberLogged = (Member) session.getAttribute("memberLogged");
        member.setId(memberLogged.getId());
        System.out.println(member.getHobbies());

        memberService.updateMember(member);
        return ("redirect:/hobbies");

    }

}
