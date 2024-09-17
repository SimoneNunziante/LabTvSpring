package com.labtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.model.Similar;
import com.labtv.services.SimilarService;

@RestController
@RequestMapping("/similar/api")
public class SimilarRestController {

	@Autowired
	private SimilarService similarservice;
	
	@GetMapping("/get/all")
	public List<Similar>getSimilars(){
		return similarservice.getSimilars();
	}
	
	@GetMapping("/get/{id}")
	public Similar getSimilarById(@PathVariable("id") int id) {
		return similarservice.getSimilarById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ObjectNode deleteSimilarById(@PathVariable("id") int id) {
		return similarservice.deleteSimilarById(id);
	}
}
