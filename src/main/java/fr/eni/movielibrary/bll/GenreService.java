package fr.eni.movielibrary.bll;


import fr.eni.movielibrary.bo.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getAllGenres();

    Genre getGenreById(Integer id);
}
