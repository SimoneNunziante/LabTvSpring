package com.labtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.labtv.model.Director;
import com.labtv.model.Film;
import com.labtv.model.Genre;
import com.labtv.model.Similar;
import com.labtv.model.Star;
import com.labtv.services.DirectorService;
import com.labtv.services.FilmService;
import com.labtv.services.GenreService;
import com.labtv.services.SimilarService;
import com.labtv.services.StarService;

@Controller
@RequestMapping("/")
public class FilmUpdateDeleteController {

	@Autowired
	private FilmService filmservice;
	
	@Autowired
	private StarService starservice;
	
	@Autowired
	private DirectorService directorservice;
	
	@Autowired
	private GenreService genreservice;
	
	@Autowired
	private SimilarService similarservice;
	
	@GetMapping("film/update/{id}")
	public String getUpdatePage(@PathVariable("id") String id, Model model) {
		Film film=filmservice.getFilmById(id);
		List<Star>stars=starservice.getStars();
		List<Director>directors=directorservice.getDirectors();
		List<Genre>genres=genreservice.getGenres();
		List<Similar>similars=similarservice.getSimilars();
		model.addAttribute("film", film);
		model.addAttribute("stars", stars);
		model.addAttribute("directors", directors);
		model.addAttribute("genres", genres);
		model.addAttribute("similars", similars);
		return "update_film";
	}
	
	@PostMapping("film/updated/{id}")
	public String updateFilm(@PathVariable int id, Film film) {
		filmservice.updateFilm(film);
		return "redirect:/film";
	}
	
	@GetMapping("film/getdelete")
	public String deleteFilm(@RequestParam("id_film") String id) {
		filmservice.deleteFilm(filmservice.getFilmById(id));
		return "redirect:/film";
	}
}
