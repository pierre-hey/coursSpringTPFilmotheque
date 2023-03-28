package fr.eni.movielibrary.dal;

import fr.eni.movielibrary.bo.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDAO extends JpaRepository<Movie, Integer> {
}
