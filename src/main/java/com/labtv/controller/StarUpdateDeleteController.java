package com.labtv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.labtv.model.Star;
import com.labtv.services.StarService;

@Controller
@RequestMapping("/")
public class StarUpdateDeleteController {

	@Autowired
	private StarService starservice;
	
	@GetMapping("star/update/{id}")
	public String getUpdatePage(@PathVariable("id") int id, Model model) {
		Star star=starservice.getStarById(id);
		model.addAttribute("star", star);
		return "update_star";
	}
	
	@PostMapping("star/updated/{id}")
	public String updateStar(@PathVariable int id, Star star) {
		starservice.updateStar(star);
		return "redirect:/star";
	}
	
	@GetMapping("star/getdelete")
	public String deleteStar(@RequestParam("id_star") int id) {
		starservice.deleteStar(starservice.getStarById(id));
		return "redirect:/star";
	}
}
