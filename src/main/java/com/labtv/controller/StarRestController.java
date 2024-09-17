package com.labtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.model.Star;
import com.labtv.services.StarService;

@RestController
@RequestMapping("/star/api")
public class StarRestController {

	@Autowired
	private StarService starservice;
	
	@GetMapping("/get/all")
	public List<Star>getStars(){
		return starservice.getStars();
	}
	
	@GetMapping("/get/{id}")
	public Star getStarById(@PathVariable("id") int id) {
		return starservice.getStarById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ObjectNode deleteStarById(@PathVariable("id") int id) {
		return starservice.deleteStarById(id);
	}
}
