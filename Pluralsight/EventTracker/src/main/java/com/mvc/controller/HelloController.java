package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mohammad on 11/21/2016.
 */
@Controller
public class HelloController {

    @GetMapping("/greeting")
    public String sayHello(Model model) {
        model.addAttribute("greeting", "Hello");

        return "hello";
    }
}
