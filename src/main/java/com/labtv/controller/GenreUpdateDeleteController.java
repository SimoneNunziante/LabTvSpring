package com.labtv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.labtv.model.Genre;
import com.labtv.services.GenreService;

@Controller
@RequestMapping("/")
public class GenreUpdateDeleteController {

	@Autowired
	private GenreService genreservice;
	
	@GetMapping("genre/update/{id}")
	public String getUpdatePage(@PathVariable("id") int id, Model model) {
		Genre genre=genreservice.getGenreById(id);
		model.addAttribute("genre", genre);
		return "update_genre";
	}
	
	@PostMapping("genre/updated/{id}")
	public String updateDirector(@PathVariable int id, Genre genre) {
		genreservice.updateGenre(genre);
		return "redirect:/genre";
	}
	
	@GetMapping("genre/getdelete")
	public String deleteDirector(@RequestParam("id_genre") int id) {
		genreservice.deleteGenre(genreservice.getGenreById(id));
		return "redirect:/genre";
	}
}
