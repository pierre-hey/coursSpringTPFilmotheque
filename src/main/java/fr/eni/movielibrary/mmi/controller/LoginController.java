package fr.eni.movielibrary.mmi.controller;

import fr.eni.movielibrary.bll.MemberService;
import fr.eni.movielibrary.bo.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
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
    public String login(Member memberForm, HttpSession session) {


        System.out.println("####### Information de connexion #######");
        System.out.println(memberForm);
        System.out.println("##############");

        // Si les informations du formulaire sont conformes à ce qu'il y a dans le mock
        // le membre est connecté, sinon renvoie vers la page de connexion
        if (!ObjectUtils.isEmpty(memberForm.getLogin()) && !ObjectUtils.isEmpty(memberForm.getPassword())) {
            Member memberChecked = memberService.checkParticipantByLoginAndPassword(memberForm.getLogin(),
                    memberForm.getPassword());

            if (!ObjectUtils.isEmpty(memberChecked)) {
                // Logged => on met le membre en session
                System.out.println("####### Connexion #######");
                System.out.println(memberChecked);
                System.out.println("##############");
                session.setAttribute("memberLogged", memberChecked);
            } else {
                // Sinon, on le dirige vers la page de login
                return "redirect:/login";
            }
        }
        return "redirect:/";
    }

    /*    @GetMapping("/logout")
        public String logout(HttpServletRequest request, // used to get cookies
                             HttpServletResponse response, // used to set cookies
                             HttpSession session, // used to remove all attributes from Jakarta EE HttpSession
                             SessionStatus sessionStatus // used to remove all attributes from Spring Session
        ) {
            sessionStatus.setComplete(); // remove all attributes from Spring Session
            session.invalidate(); // remove all attributes from Jakarta EE HttpSession
            if (request.getCookies() != null) { // NullPointerException
                for (Cookie cookie : request.getCookies()) { // remove all cookies except JSESSIONID
                    if (!cookie.getName().equals("JSESSIONID")) { // keep new JSESSIONID given by session.invalidate()
                        cookie.setValue(null); // do not transmit the values to the client
                        cookie.setMaxAge(0); // ask the client to remove the cookie
                        response.addCookie(cookie); // send action to the client
                    }
                }
            }
            return "login";
        }*/
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("memberLogged", null);
        return "redirect:/login";
    }
}
