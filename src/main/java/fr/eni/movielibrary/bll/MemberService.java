package fr.eni.movielibrary.bll;

import fr.eni.movielibrary.bo.Member;

public interface MemberService {

    Member findParticipantByUserName(Member member);
}
