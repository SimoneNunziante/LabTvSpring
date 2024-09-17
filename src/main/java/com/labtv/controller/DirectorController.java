package com.labtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labtv.model.Director;
import com.labtv.services.DirectorService;

@Controller
@RequestMapping("/")
public class DirectorController {

	@Autowired
	private DirectorService directorservice;
	
	@GetMapping("director")
	public String getPage(Model model) {
		List<Director>directors=directorservice.getDirectors();
		model.addAttribute("directors", directors);
		return "director";
	}
}
