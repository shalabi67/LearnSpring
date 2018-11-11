package com.reactor.rest.interval;

import com.reactor.rest.models.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class IntervalFluxController {
    public static final String URL = "/interval";
    public static final String PEOPLE_URL = "/people";

    @GetMapping(URL)
    public Flux<Integer> getIntervals() {
        Flux<Integer> numbersFlux = Flux.range(1, 10000);
        return numbersFlux;
    }
    @GetMapping(PEOPLE_URL)
    public Flux<Person> getPeople() {
        Flux<Person> peopleFlux = Flux.create(emitter -> {
            Flux.interval(Duration.ofMillis(10))
                    .subscribe(delay -> emitter.next(new Person("First " + delay, "last Name")));
        });
        return peopleFlux;
    }
}
