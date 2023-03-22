package fr.eni.movielibrary.bll.impl;

import fr.eni.movielibrary.bll.MemberService;
import fr.eni.movielibrary.bo.Member;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("dev")
public class MemberServiceMock implements MemberService {

    private static List<Member> memberList;

    public MemberServiceMock() {
        // Création des membres
        Member member = new Member();
        member.setId(1);
        member.setUserName("Pierre");
        member.setPassword("1234");
        member.setIsAdmin(true);

        Member member2 = new Member();
        member2.setId(2);
        member2.setUserName("Anne-Lise");
        member2.setPassword("4321");
        member2.setIsAdmin(true);

        memberList = new ArrayList<>();
        memberList.add(member);
        memberList.add(member2);
    }


    @Override
    public Member findParticipantByUserName(Member member) {

        System.out.println(member.toString());
        for (Member m : memberList) {
            // Si username et mdp sont identiques à un des membres, on considère que le login est ok
            if (member.getUserName().equals(m.getUserName()) && member.getPassword().equals(m.getPassword())) {
                return member;
            }
        }
        return null;
    }
}
