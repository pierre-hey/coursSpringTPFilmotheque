package fr.eni.movielibrary.dal;

import fr.eni.movielibrary.bo.Opinion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionDAO extends CrudRepository<Opinion, Integer> {
}
