package fr.eni.movielibrary.bll.impl.mock;

import fr.eni.movielibrary.bll.MemberService;
import fr.eni.movielibrary.bo.Member;
import fr.eni.movielibrary.dal.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


@Service
@Profile("pasdev")
public class MemberServiceMock implements MemberService {

    private final MemberDAO memberDAO;

    @Autowired
    public MemberServiceMock(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }


    @Override
    public Member checkParticipantByLoginAndPassword(String login, String password) {

        // Recherche en bdd le membre par son login
        Member member = findMemberByLogin(login);
        // Si le membre est trouvé par son login, on vérifie le mdp, si les mdp sont identiques -> on retourne le membre, sinon null
        if (!ObjectUtils.isEmpty(member)) {
            if (password.equals(member.getPassword())) {
                return member;
            }
        }
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

    @Override
    public Member findMemberByLoginAndPassword(String login, String password) {
        return null;
    }
}
