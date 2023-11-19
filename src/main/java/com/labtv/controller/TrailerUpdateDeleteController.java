package com.labtv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.labtv.model.Trailer;
import com.labtv.services.TrailerService;

@Controller
@RequestMapping("/")
public class TrailerUpdateDeleteController {

	@Autowired
	private TrailerService trailerservice;
	
	@GetMapping("trailer/update/{id}")
	public String getUpdatePage(@PathVariable("id") int id, Model model) {
		Trailer trailer=trailerservice.getTrailerById(id);
		model.addAttribute("trailer", trailer);
		return "update_trailer";
	}
	
	@PostMapping("trailer/updated/{id}")
	public String updateTrailer(@PathVariable int id, Trailer trailer) {
		trailerservice.updateTrailer(trailer);
		return "redirect:/trailer";
	}
	
	@GetMapping("trailer/getdelete")
	public String deleteTrailer(@RequestParam("id_trailer") int id) {
		trailerservice.deleteTrailer(trailerservice.getTrailerById(id));
		return "redirect:/trailer";
	}
}
