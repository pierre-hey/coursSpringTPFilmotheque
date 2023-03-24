package fr.eni.movielibrary.bll.impl;

import fr.eni.movielibrary.bll.GenreService;
import fr.eni.movielibrary.bo.Genre;
import fr.eni.movielibrary.dal.GenreDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreDAO genreDAO;

    public GenreServiceImpl(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    @Override
    public List<Genre> findAllGenres() {
        return (List<Genre>) genreDAO.findAll();
    }

    @Override
    public Genre findGenreById(Integer id) {
        return genreDAO.findById(id).orElse(null);
    }
}
