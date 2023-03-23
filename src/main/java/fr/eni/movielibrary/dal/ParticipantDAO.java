package fr.eni.movielibrary.dal;

import fr.eni.movielibrary.bo.Participant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantDAO extends CrudRepository<Participant,Integer> {
}
