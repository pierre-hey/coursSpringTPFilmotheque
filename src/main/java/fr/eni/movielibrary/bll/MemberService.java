package fr.eni.movielibrary.bll;

import fr.eni.movielibrary.bo.Member;

public interface MemberService {

    Member findParticipantByUserNameAndPassword(String userName, String password);
}
