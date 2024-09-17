package com.labtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.model.Genre;
import com.labtv.services.GenreService;

@RestController
@RequestMapping("/genre/api")
public class GenreRestController {

	@Autowired
	private GenreService genreservice;
	
	@GetMapping("/get/all")
	public List<Genre>getGenres(){
		return genreservice.getGenres();
	}
	
	@GetMapping("/get/{id}")
	public Genre getGenreById(@PathVariable("id") int id) {
		return genreservice.getGenreById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ObjectNode deleteGenreById(@PathVariable("id") int id) {
		return genreservice.deleteGenreById(id);
	}
}
