package com.learn.petclinic.controllers;

import com.learn.petclinic.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
	public static final String OWNER_URL = "owners";
	public static final String OWNER_BEGIN = "/" + PersonController.OWNER_URL;
	public static final String VETS_URL = "vets";
	public static final String VETS_BEGIN = "/" + PersonController.VETS_URL;
	public static final String MODEL = "/index";
	private static final String HTML_EXT = ".html";
	private static final String HTM_EXT = ".htm";
	public static final String FIND = "/find";

	private PersonService personService;
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping({ VETS_BEGIN, VETS_BEGIN + MODEL + HTM_EXT,VETS_BEGIN + MODEL + HTML_EXT, VETS_BEGIN + MODEL,
			VETS_URL, VETS_URL + HTM_EXT, VETS_URL + HTML_EXT})
	public String showVets(Model model) {
		model.addAttribute("vets", personService.getVets());
		return VETS_URL + MODEL;
	}

	@RequestMapping({ OWNER_BEGIN, OWNER_BEGIN + MODEL + HTM_EXT,OWNER_BEGIN + MODEL + HTML_EXT, OWNER_BEGIN + MODEL})
	public String showOwners(Model model) {
		model.addAttribute("owners", personService.getOwners());
		return OWNER_URL + MODEL;
	}

	@RequestMapping({ OWNER_BEGIN + FIND + HTM_EXT, OWNER_BEGIN + FIND + HTML_EXT, OWNER_BEGIN + FIND})
	public String findOwners(Model model) {
		model.addAttribute("owners", personService.getOwners());
		return "errors" + "/not-implemented";
	}

}
