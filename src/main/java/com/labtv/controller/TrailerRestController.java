package com.labtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.model.Trailer;
import com.labtv.services.TrailerService;

@RestController
@RequestMapping("/trailer/api")
public class TrailerRestController {

	@Autowired
	private TrailerService trailerservice;
	
	@GetMapping("/get/all")
	public List<Trailer>getTrailers(){
		return trailerservice.getTrailers();
	}
	
	@GetMapping("/get/{id}")
	public Trailer getTrailerById(@PathVariable("id") int id) {
		return trailerservice.getTrailerById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ObjectNode deleteTrailerById(@PathVariable("id") int id) {
		return trailerservice.deleteTrailerById(id);
	}
}
