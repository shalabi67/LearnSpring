package com.learn.configuration.conditionalconfiguration.controllers;

import com.learn.configuration.conditionalconfiguration.data.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mohammad on 10/21/2017.
 */
@RestController
public class HelloController {

    @Autowired
    private Hello hello;

    @RequestMapping("/")
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<String>(hello.getHelloMessage(), HttpStatus.OK);
    }
}
