package fr.eni.movielibrary.bll;

import fr.eni.movielibrary.bo.Participant;

import java.util.List;

public interface ParticipantService {

    List<Participant> getALlParticipants();

    Participant getParticipantById(Integer id);

}
