package com.labtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.labtv.model.Evidenza;
import com.labtv.services.EvidenzaService;

@Controller
@RequestMapping("/")
public class EvidenzaController {

	@Autowired
	private EvidenzaService evidenzaservice;
	
	@GetMapping("evidenza")
	public String getPage(Model model) {
		List<Evidenza>evidenze=evidenzaservice.getEvidenze();
		model.addAttribute("evidenze", evidenze);
		return "evidenza";
	}
	
    @GetMapping("/title-search")
    public String searchByTitle(@RequestParam("title") String title, Model model) {
        List<Evidenza> evidenze = evidenzaservice.getFilmByTitle(title);
        model.addAttribute("evidenze", evidenze);
        return "search-results"; 
    }
}
