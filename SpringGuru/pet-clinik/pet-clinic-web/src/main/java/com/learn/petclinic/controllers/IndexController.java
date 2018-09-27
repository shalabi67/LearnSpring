package com.learn.petclinic.controllers;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
public class IndexController {

	@RequestMapping({"/", "", "index.html", "index.htm"})
	public String showIndex(Model model) {
		return "index";
	}
}
