package com.rkb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rkb.models.LocationStat;
import com.rkb.services.CoronaVirusDataService;

@Controller
public class HomeController {
	
	@Autowired
	private CoronaVirusDataService service;
	
	@GetMapping("/")
	public String home(Model model) {
	List<LocationStat> list =	service.getAllStats();
	int sum = list.stream().mapToInt(mapper -> Integer.parseInt(mapper.getCases())).sum();
		model.addAttribute("allStats", list);
		model.addAttribute("total", sum);
		return "home";
	}

}
