package fr.eni.movielibrary.dal;

import fr.eni.movielibrary.bo.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreDAO extends CrudRepository<Genre,Integer> {
}
