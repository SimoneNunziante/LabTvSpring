package com.labtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.model.Director;
import com.labtv.services.DirectorService;

@RestController
@RequestMapping("/director/api")
public class DirectorRestController {

	@Autowired
	private DirectorService directorservice;
	
	@GetMapping("/get/all")
	public List<Director>getDirectors(){
		return directorservice.getDirectors();
	}
	
	@GetMapping("/get/{id}")
	public Director getDirectorById(@PathVariable("id") int id) {
		return directorservice.getDirectorById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ObjectNode deleteDirectorById(@PathVariable("id") int id){
		return directorservice.deleteDirectorById(id);
	}
	
}
