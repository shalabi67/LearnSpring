package com.reactor.backpressure.server.person;

import com.reactor.backpressure.server.delay.DelayController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController(PersonController.URL)
public class PersonController {
    public static final String URL = "/people";

    @GetMapping(URL)
    public Flux<Person> getPersons() {
        Flux<Person> personFlux = Flux.just(
                new Person("Mohammad", "Shalabi"),
                new Person("Elham", "Shalabi"),
                new Person("Kamel", "Shalabi"),
                new Person("Samar", "Shalabi"),
                new Person("Sandra", "Shalabi"));

        try {
            Thread.sleep(DelayController.getDelay());
        } catch (InterruptedException e) {
            return Flux.just( new Person("Error", "Error"));
        }

        return personFlux;
    }
}
