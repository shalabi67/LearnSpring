package com.learn.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/" + VetController.VETS_URL)
@Controller
public class VetController {
	static final String VETS_URL = "vets";
	private static final String MODEL = "/index";
	private static final String HTML_EXT = ".html";
	private static final String HTM_EXT = ".htm";

	@RequestMapping({ "", MODEL + HTML_EXT, MODEL, MODEL + HTM_EXT})
	public String showVets(Model model) {
		return VETS_URL + MODEL;
	}
}
