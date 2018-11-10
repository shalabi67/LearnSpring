package com.reactor.rest.controllers;

import com.reactor.rest.models.Person;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * example shows how to call Flux get entry point http://localhost:8080/example1
 */
public class Example1WebClient {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create("http://localhost:8080");
        Flux<Person> namesFlux = webClient.get().uri("/example1")
                .accept(MediaType.ALL)
                .retrieve()
                .bodyToFlux(Person.class);

        List<Person> people = namesFlux
                .collectList()
                .block();

        people.forEach(person -> System.out.println(person.getFirstName() + "  " + person.getLastName()));
    }
}
