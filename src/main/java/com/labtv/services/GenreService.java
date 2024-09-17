package com.labtv.services;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.model.Genre;

public interface GenreService {

	void saveGenre(Genre genre);
	List<Genre>getGenres();
	Genre getGenreById(int id);
	void updateGenre(Genre genre);
	ObjectNode deleteGenreById(int id);
	void deleteGenre(Genre genre);
}
