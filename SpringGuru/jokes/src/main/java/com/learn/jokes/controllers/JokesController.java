package com.learn.jokes.controllers;

import com.learn.jokes.services.JokesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JokesController {

	private JokesService jokesService;
	public JokesController(JokesService jokesService) {
		this.jokesService = jokesService;
	}

	@RequestMapping(value = "/")
	public String getRandomJoke(Model model) {
		String joke = jokesService.getQuote();
		model.addAttribute("joke", joke);
		return "joke";
	}
}
