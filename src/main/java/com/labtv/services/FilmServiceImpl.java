package com.labtv.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.dao.FilmDao;
import com.labtv.helper.ResponseManager;
import com.labtv.model.Film;

@Service
public class FilmServiceImpl implements FilmService{

	@Autowired
	private FilmDao filmdao;
	
	@Override
	public void saveFilm(Film film) {
		filmdao.save(film);
	}
	
	@Override
	public List<Film>getFilm(){
		ArrayList<Film>film=(ArrayList<Film>)filmdao.findAll();
		return film;
	}
	
	@Override
	public Film getFilmById(String id) {
		return filmdao.findById(id).get();
	}
	
	@Override
	public void updateFilm(Film film) {
		filmdao.save(film);
	}
	
	@Override
	public ObjectNode deleteFilmById(String id) {
		Optional<Film>filmOptional=filmdao.findById(id);
		if(!filmOptional.isPresent()) {
			return new ResponseManager(404, "film not found").getResponse();
		}
		else {
			filmdao.delete(filmOptional.get());
			return new ResponseManager(202, "film deleted").getResponse();
		}
	}
	
	@Override
	public void deleteFilm(Film film) {
		filmdao.delete(film);
	}
	
}
