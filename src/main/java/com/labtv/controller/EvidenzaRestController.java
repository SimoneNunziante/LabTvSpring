package com.labtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.labtv.model.Evidenza;
import com.labtv.services.EvidenzaService;

@RestController
@RequestMapping("/evidenza/api")
public class EvidenzaRestController {

	@Autowired
	private EvidenzaService evidenzaservice;
	
	@GetMapping("/get/all")
	public List<Evidenza>getEvidenze(){
		return evidenzaservice.getEvidenze();
	}
	
	@GetMapping("/get/{id}")
	public Evidenza getEvidenzaById(@PathVariable("id") String id) {
		return evidenzaservice.getEvidenzaById(id);
	}
	
	@GetMapping("/title/{title}")
	public List<Evidenza>getFilmByTitle(@PathVariable("title") String title){
		return evidenzaservice.getFilmByTitle(title);
	}
	
	@DeleteMapping("/delete/{id}")
	public ObjectNode deleteEvidenzaById(@PathVariable("id") String id) {
		return evidenzaservice.deleteEvidenzaById(id);
	}
}
