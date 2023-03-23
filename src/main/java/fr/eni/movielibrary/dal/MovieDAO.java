package fr.eni.movielibrary.dal;

import fr.eni.movielibrary.bo.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDAO extends CrudRepository<Movie, Integer> {
}
