package fr.eni.movielibrary.bll.impl;

import fr.eni.movielibrary.bll.MemberService;
import fr.eni.movielibrary.bo.Member;
import fr.eni.movielibrary.dal.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("pasdev")
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Autowired
    public MemberServiceImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public Member checkParticipantByLoginAndPassword(String userName, String password) {
        return null;
    }

    @Override
    public Member findMemberByLogin(String login) {
        return memberDAO.findMemberByLogin(login);
    }

    @Override
    public void updateMember(Member member) {
        memberDAO.save(member);
    }
}
