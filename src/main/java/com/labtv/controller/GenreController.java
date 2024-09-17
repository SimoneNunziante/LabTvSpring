package com.labtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labtv.model.Genre;
import com.labtv.services.GenreService;

@Controller
@RequestMapping("/")
public class GenreController {

	@Autowired
	private GenreService genreservice;
	
	@GetMapping("genre")
	public String getPage(Model model) {
		List<Genre>genres=genreservice.getGenres();
		model.addAttribute("genres", genres);
		return "genre";
	}
}
