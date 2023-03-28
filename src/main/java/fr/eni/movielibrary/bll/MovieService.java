package fr.eni.movielibrary.bll;

import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.bo.Opinion;

import java.util.List;

/**
 * Service de la classe Movie
 */
public interface MovieService {

    /**
     * Recherche tous les films
     *
     * @return liste de film
     */
    List<Movie> findAllMovies();

    /**
     * Recherche un film par son id
     *
     * @param id id du film
     * @return film
     */
    Movie findMovieById(Integer id);

    /**
     * Créé un film
     *
     * @param movie film
     */
    void createMovie(Movie movie);

    /**
     * Supprime un film
     *
     * @param movie film
     */
    void deleteMovie(Movie movie);

    /**
     * Met à jour un film
     *
     * @param movie film
     */
    void updateMovie(Movie movie);

    void saveOpinion(Opinion opinion, Movie movie);

}
