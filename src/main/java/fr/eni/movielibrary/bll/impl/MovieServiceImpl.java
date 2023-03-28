package fr.eni.movielibrary.bll.impl;

import fr.eni.movielibrary.bll.MovieService;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.bo.Opinion;
import fr.eni.movielibrary.dal.MovieDAO;
import fr.eni.movielibrary.dal.OpinionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile("dev")
public class MovieServiceImpl implements MovieService {

    private final MovieDAO movieDao;
    private final OpinionDAO opinionDAO;

    @Autowired
    public MovieServiceImpl(MovieDAO movieDao, OpinionDAO opinionDAO) {
        this.movieDao = movieDao;
        this.opinionDAO = opinionDAO;
    }

    @Override
    public List<Movie> findAllMovies() {
        return (List<Movie>) movieDao.findAll();
    }

    @Override
    public Movie findMovieById(Integer id) {
        return movieDao.findById(id).orElse(null);
    }

    @Override
    public void createMovie(Movie movie) {
        movieDao.save(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieDao.delete(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        movieDao.save(movie);
    }

    @Override
    public void saveOpinion(Opinion opinion, Movie movie) {

            movie.addOpinion(opinion);

            movieDao.save(movie);

    }


}
