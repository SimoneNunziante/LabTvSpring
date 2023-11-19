package com.labtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labtv.model.Star;
import com.labtv.services.StarService;

@Controller
@RequestMapping("/")
public class StarController {

	@Autowired
	private StarService starservice;
	
	@GetMapping("star")
	public String getPage(Model model) {
		List<Star>stars=starservice.getStars();
		model.addAttribute("stars", stars);
		return "star";
	}
}
