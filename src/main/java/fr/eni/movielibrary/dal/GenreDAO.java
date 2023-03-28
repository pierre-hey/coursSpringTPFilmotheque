package fr.eni.movielibrary.dal;

import fr.eni.movielibrary.bo.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreDAO extends JpaRepository<Genre,Integer> {
}
