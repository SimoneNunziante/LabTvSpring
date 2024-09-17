package com.labtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labtv.model.Trailer;
import com.labtv.services.TrailerService;

@Controller
@RequestMapping("/")
public class TrailerController {

	@Autowired
	private TrailerService trailerservice;
	
	@GetMapping("trailer")
	public String getPage(Model model) {
		List<Trailer>trailers=trailerservice.getTrailers();
		model.addAttribute("trailers", trailers);
		return "trailer";
	}
}
