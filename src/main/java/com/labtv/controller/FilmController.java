package com.labtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class FilmController {

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
	
	
	@GetMapping("film")
	public String getPage(Model model) {
		List<Film>film=filmservice.getFilm();
		List<Star>stars=starservice.getStars();
		List<Director>directors=directorservice.getDirectors();
		List<Genre>genres=genreservice.getGenres();
		List<Similar>similars=similarservice.getSimilars();
		model.addAttribute("film", film);
		model.addAttribute("stars", stars);
		model.addAttribute("directors", directors);
		model.addAttribute("genres", genres);
		model.addAttribute("similars", similars);
		return "film";
	}

}
