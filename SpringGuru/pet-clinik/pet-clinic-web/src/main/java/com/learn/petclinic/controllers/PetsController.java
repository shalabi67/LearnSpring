package com.learn.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/" + PetsController.PETS_URL)
@Controller
public class PetsController {
	static final String PETS_URL = "pets";
	private static final String MODEL = "/index";
	private static final String HTML_EXT = ".html";
	private static final String HTM_EXT = ".htm";

	@RequestMapping({ "", MODEL + HTML_EXT, MODEL, MODEL + HTM_EXT})
	public String showPets(Model model) {
		return PETS_URL + MODEL;
	}
}
