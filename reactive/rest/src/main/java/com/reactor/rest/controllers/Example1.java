package com.reactor.rest.controllers;

import com.reactor.rest.models.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * this application can be called normally through web browser http://localhost:8080/example1
 */
@RestController
public class Example1 {

    @GetMapping("/example1")
    public Flux<Person> getHello() {
        return Flux.just( new Person("Mohammad", "Shalabi"),
                new Person("Elham", "Shalabi"),
                new Person("Kamel", "Shalabi"),
                new Person("Samar", "Shalabi"),
                new Person("Sandra", "Shalabi"));
    }
}
