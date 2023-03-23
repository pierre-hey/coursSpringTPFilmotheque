package fr.eni.movielibrary.bll;

import fr.eni.movielibrary.bo.Member;

public interface MemberService {
    /**
     * Vérifie que le login et mdp du membre qui essaye de se connecter sont identiques
     *
     * @param login    login membre
     * @param password mdp membre
     * @return membre
     */
    Member checkParticipantByLoginAndPassword(String login, String password);

    Member findMemberByLogin(String login);

    void updateMember(Member member);
}
