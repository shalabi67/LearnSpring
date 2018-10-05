package com.learn.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	static final String ERRORS_URL = "errors";
	private static final String OUPS_URL = "oups";
	private static final String MODEL = "/index";
	private static final String OUPS = "/oups";
	private static final String HTML_EXT = ".html";
	private static final String HTM_EXT = ".htm";

	@RequestMapping({ OUPS_URL, OUPS + HTML_EXT, OUPS, OUPS + HTM_EXT,
			ERRORS_URL + OUPS + HTML_EXT, ERRORS_URL + OUPS + HTM_EXT, ERRORS_URL + OUPS})
	public String showOups() {
		return ERRORS_URL + OUPS;
	}

	@RequestMapping({ ERRORS_URL, ERRORS_URL + MODEL + HTML_EXT, ERRORS_URL + MODEL, ERRORS_URL + MODEL + HTM_EXT})
	public String showError() {
		return ERRORS_URL + MODEL;
	}

}
