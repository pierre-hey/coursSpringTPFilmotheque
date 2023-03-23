package fr.eni.movielibrary.bll;

import fr.eni.movielibrary.bo.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie getMovieById(Integer id);

    void saveMovie(Movie movie);

    void deleteMovie(Movie movie);
}
