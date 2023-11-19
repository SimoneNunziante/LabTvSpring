package com.labtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.model.Film;
import com.labtv.services.FilmService;

@RestController
@RequestMapping("/film/api")
public class FilmRestController {

	@Autowired
	private FilmService filmservice;
	
	@GetMapping("/get/all")
	public List<Film>getFilm(){
		return filmservice.getFilm();
	}
	
	@GetMapping("/get/{id}")
	public Film getFilmById(@PathVariable("id") String id) {
		return filmservice.getFilmById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ObjectNode deleteFilmById(@PathVariable("id") String id) {
		return filmservice.deleteFilmById(id);
	}
}
