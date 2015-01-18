package org.java.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {
	
	@RequestMapping("/about")
	public String about(Model model) {
		//model.addAttribute("users", userService.findAll());
		return "about";
		
	}

	@RequestMapping("/contact")
	public String contact(Model model) {
		//model.addAttribute("contact", userService.findAll());
		return "contact";
		
	}
}
