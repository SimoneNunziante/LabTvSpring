package com.labtv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.labtv.model.Evidenza;
import com.labtv.services.EvidenzaService;

@Controller
@RequestMapping("/")
public class EvidenzaUpdateDeleteController {

	@Autowired
	EvidenzaService evidenzaservice;
	
	@GetMapping("evidenza/update/{id}")
	public String getUpdatePage(@PathVariable("id") String id, Model model) {
		Evidenza evidenza=evidenzaservice.getEvidenzaById(id);
		model.addAttribute("evidenza", evidenza);
		return "update_evidenza";
	}
	
	@PostMapping("evidenza/updated/{id}")
	public String updateEvidenza(@PathVariable String id, Evidenza evidenza) {
		evidenzaservice.updateEvidenza(evidenza);
		return "redirect:/evidenza";
	}
	
	@GetMapping("evidenza/getdelete")
	public String deleteEvidenza(@RequestParam("id_evidenza") String id) {
		evidenzaservice.deleteEvidenza(evidenzaservice.getEvidenzaById(id));
		return "redirect:/evidenza";
	}
}
