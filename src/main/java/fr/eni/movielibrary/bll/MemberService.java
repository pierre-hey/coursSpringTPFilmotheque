package fr.eni.movielibrary.bll;

import fr.eni.movielibrary.bo.Member;


/**
 * Service de la classe Member
 */
public interface MemberService {
    /**
     * Vérifie que le login et mdp du membre qui essaye de se connecter sont identiques
     *
     * @param login    login membre
     * @param password mdp membre
     * @return membre
     */
    Member checkParticipantByLoginAndPassword(String login, String password);

    /**
     * Recherche un membre par son login
     *
     * @param login login du membre
     * @return membre
     */
    Member findMemberByLogin(String login);

    /**
     * Met à jour un membre
     *
     * @param member membre à mettre à jour
     */
    void updateMember(Member member);

    /**
     * Recherche un membre avec son login et son mot de passe
     *
     * @param login    login
     * @param password mot de passe
     * @return membre
     */
    Member findMemberByLoginAndPassword(String login, String password);
}
