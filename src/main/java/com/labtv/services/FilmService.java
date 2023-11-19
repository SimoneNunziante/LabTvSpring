package com.labtv.services;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.model.Film;

public interface FilmService {

	void saveFilm(Film film);
	List<Film>getFilm();
	Film getFilmById(String id);
	void updateFilm(Film film);
	ObjectNode deleteFilmById(String id);
	void deleteFilm(Film film);
}
