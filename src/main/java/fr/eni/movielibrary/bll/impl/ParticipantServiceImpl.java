package fr.eni.movielibrary.bll.impl;

import fr.eni.movielibrary.bll.ParticipantService;
import fr.eni.movielibrary.bo.Participant;
import fr.eni.movielibrary.dal.ParticipantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    ParticipantDAO participantDAO;

    @Autowired
    public ParticipantServiceImpl(ParticipantDAO participantDAO) {
        this.participantDAO = participantDAO;
    }

    @Override
    public List<Participant> findALlParticipants() {
        return (List<Participant>) participantDAO.findAll();
    }

    @Override
    public Participant findParticipantById(Integer id) {
        return participantDAO.findById(id).orElse(null);
    }
}
