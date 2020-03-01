package com.rkb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rkb.services.CoronaVirusDataService;

import org.springframework.ui.Model;

@Controller
public class HomeController {
	
	@Autowired
	private CoronaVirusDataService service;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("allStats", service.getAllStats());
		return "home";
	}

}
