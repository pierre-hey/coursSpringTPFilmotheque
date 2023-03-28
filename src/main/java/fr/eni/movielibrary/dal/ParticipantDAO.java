package fr.eni.movielibrary.dal;

import fr.eni.movielibrary.bo.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantDAO extends JpaRepository<Participant,Integer> {
}
