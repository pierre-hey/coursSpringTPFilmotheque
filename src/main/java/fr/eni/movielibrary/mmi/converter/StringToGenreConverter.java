package fr.eni.movielibrary.mmi.converter;

import fr.eni.movielibrary.bll.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.eni.movielibrary.bo.Genre;

@Component
public class StringToGenreConverter implements Converter<String, Genre> {
	// Injection des services
	//private final MovieService service;
	private final GenreService service;

	@Autowired
	public StringToGenreConverter(GenreService service) {
		this.service = service;
	}

	@Override
	public Genre convert(String id) {
		Integer theId = Integer.parseInt(id);
		return service.findGenreById(theId);
	}
}