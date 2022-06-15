package com.example.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController1 {
	
	@GetMapping("/home1")
	public String home(Model model) {
		model.addAttribute("id", "20220001");
		return "id";
	}

}
