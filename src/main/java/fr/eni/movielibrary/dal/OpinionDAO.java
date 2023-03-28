package fr.eni.movielibrary.dal;

import fr.eni.movielibrary.bo.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionDAO extends JpaRepository<Opinion, Integer> {
}
