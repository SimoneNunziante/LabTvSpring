package com.labtv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.labtv.model.Similar;
import com.labtv.services.SimilarService;

@Controller
@RequestMapping("/")
public class SimilarUpdateDeleteController {

	@Autowired
	SimilarService similarservice;
	
	@GetMapping("similar/update/{id}")
	public String getUpdatePage(@PathVariable("id") int id, Model model) {
		Similar similar=similarservice.getSimilarById(id);
		model.addAttribute("similar", similar);
		return "update_similar";
	}
	
	@PostMapping("similar/updated/{id}")
	public String updateSimilar(@PathVariable int id, Similar similar) {
		similarservice.updateSimilar(similar);
		return "redirect:/similar";
	}
	
	@GetMapping("similar/getdelete")
	public String deleteSimilar(@RequestParam("id_similar") int id) {
		similarservice.deleteSimilar(similarservice.getSimilarById(id));
		return "redirect:/similar";
	}
}
