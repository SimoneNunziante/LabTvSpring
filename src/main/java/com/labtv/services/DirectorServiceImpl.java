package com.labtv.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.dao.DirectorDao;
import com.labtv.helper.ResponseManager;
import com.labtv.model.Director;

@Service
public class DirectorServiceImpl implements DirectorService{

	@Autowired
	private DirectorDao directordao;
	
	@Override
	public void saveDirector(Director director) {
		directordao.save(director);
	}
	
	@Override
	public List<Director>getDirectors(){
		ArrayList<Director>directors=(ArrayList<Director>)directordao.findAll();
		return directors;
	}
	
	@Override
	public Director getDirectorById(int id) {
		return directordao.findById(id).get();
	}
	
	@Override
	public void updateDirector(Director director) {
		directordao.save(director);
	}
	
	@Override
	public ObjectNode deleteDirectorById(int id) {
		Optional<Director>directorOptional=directordao.findById(id);
		if(!directorOptional.isPresent()) {
			return new ResponseManager(404, "Director not found").getResponse();
		}
		else {
			directordao.delete(directorOptional.get());
			return new ResponseManager(202, "Director deleted").getResponse();
		}
	}
	
	@Override
	public void deleteDirector(Director director) {
		directordao.delete(director);
	}
}
