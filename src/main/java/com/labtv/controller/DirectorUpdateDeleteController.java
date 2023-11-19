package com.labtv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.labtv.model.Director;
import com.labtv.services.DirectorService;

@Controller
@RequestMapping("/")
public class DirectorUpdateDeleteController {

	@Autowired
	private DirectorService directorservice;
	
	@GetMapping("director/update/{id}")
	public String getUpdatePage(@PathVariable("id") int id, Model model) {
		Director director=directorservice.getDirectorById(id);
		model.addAttribute("director", director);
		return "update_director";
	}
	
	@PostMapping("director/updated/{id}")
	public String updateDirector(@PathVariable int id, Director director) {
		directorservice.updateDirector(director);
		return "redirect:/director";
	}
	
	@GetMapping("director/getdelete")
	public String deleteDirector(@RequestParam("id_director") int id) {
		directorservice.deleteDirector(directorservice.getDirectorById(id));
		return "redirect:/director";
	}
}
