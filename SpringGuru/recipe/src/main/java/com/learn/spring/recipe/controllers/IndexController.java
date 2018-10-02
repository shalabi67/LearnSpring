package com.learn.spring.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({"","/", "/index", "index.html", "index.htm"})
	public String showMainPage() {
		return "index";
	}
}
