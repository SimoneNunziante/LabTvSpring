package com.labtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labtv.model.Similar;
import com.labtv.services.SimilarService;

@Controller
@RequestMapping("/")
public class SimilarController {

	@Autowired
	private SimilarService similarservice;
	
	@GetMapping("similar")
	public String getPage(Model model) {
		List<Similar>similars=similarservice.getSimilars();
		model.addAttribute("similars", similars);
		return "similar";
	}
}
