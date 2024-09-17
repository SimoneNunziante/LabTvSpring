package com.labtv.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.dao.GenreDao;
import com.labtv.helper.ResponseManager;
import com.labtv.model.Genre;

@Service
public class GenreServiceImpl implements GenreService{

	@Autowired
	private GenreDao genredao;
	
	@Override
	public void saveGenre(Genre genre) {
		genredao.save(genre);
	}
	
	@Override
	public List<Genre>getGenres(){
		ArrayList<Genre>genres=(ArrayList<Genre>)genredao.findAll();
		return genres;
	}
	
	@Override
	public Genre getGenreById(int id) {
		return genredao.findById(id).get();
	}
	
	@Override
	public void updateGenre(Genre genre) {
		genredao.save(genre);
	}
	
	@Override
	public ObjectNode deleteGenreById(int id) {
		Optional<Genre>genreOptional=genredao.findById(id);
		if(!genreOptional.isPresent()) {
			return new ResponseManager(404, "genre not found").getResponse();
		}
		else {
			genredao.delete(genreOptional.get());
			return new ResponseManager(202, "genre deleted").getResponse();
		}
	}
	
	@Override
	public void deleteGenre(Genre genre) {
		genredao.delete(genre);
	}
	
}
