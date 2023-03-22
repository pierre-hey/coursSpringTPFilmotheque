package fr.eni.movielibrary.bll;

import fr.eni.movielibrary.bo.Genre;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.bo.Participant;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie getMovieById(long id);

    List<Genre> getGenres();

    List<Participant> getParticipants();

    public Genre getGenreById(long id);

    public Participant getParticipantById(long id);

    public void saveMovie(Movie movie);
}
