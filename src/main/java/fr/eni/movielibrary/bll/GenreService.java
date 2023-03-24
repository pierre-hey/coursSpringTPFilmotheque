package fr.eni.movielibrary.bll;


import fr.eni.movielibrary.bo.Genre;

import java.util.List;

/**
 * Service de la classe Genre
 */
public interface GenreService {

    /**
     * Recherche tous les genres de film
     *
     * @return liste de genres
     */
    List<Genre> findAllGenres();

    /**
     * Recherche un genre par son id
     *
     * @param id id du genre
     * @return genre
     */
    Genre findGenreById(Integer id);
}
