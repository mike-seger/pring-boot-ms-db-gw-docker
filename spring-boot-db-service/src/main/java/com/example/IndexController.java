package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping({"/", "${spring.application.name}"})
	public String home(Model model, @Value("${spring.application.name}") String appName) {
		model.addAttribute("appName", appName);
		return "index";
	}
}
