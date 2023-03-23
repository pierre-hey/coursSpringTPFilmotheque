package fr.eni.movielibrary.bll;

import fr.eni.movielibrary.bo.Member;

public interface MemberService {

    Member checkParticipantByLoginAndPassword(String login, String password);

    Member findMemberByLogin(String login);

}
