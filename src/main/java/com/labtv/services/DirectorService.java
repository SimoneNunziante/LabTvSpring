package com.labtv.services;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.model.Director;

public interface DirectorService {

	void saveDirector(Director director);
	List<Director>getDirectors();
	Director getDirectorById(int id);
	void updateDirector(Director director);
	ObjectNode deleteDirectorById(int id);
	void deleteDirector(Director director);
}
