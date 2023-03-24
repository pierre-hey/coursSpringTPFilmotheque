package fr.eni.movielibrary.bll;

import fr.eni.movielibrary.bo.Participant;

import java.util.List;

/**
 * Service de la classe Participant
 */
public interface ParticipantService {

    /**
     * Recherche tous les participants
     *
     * @return liste de participant
     */
    List<Participant> findALlParticipants();

    /**
     * Recherche un participant par son id
     *
     * @param id id participant
     * @return participant
     */
    Participant findParticipantById(Integer id);

}
