package com.reactor.rest.interval;

import com.reactor.rest.models.Person;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        showRange();
    }
    private static void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void showRange() {
        WebClient webClient = WebClient.create("http://localhost:8080");
        Flux<Integer> longFlux = webClient.get().uri(IntervalFluxController.URL)
                .accept(MediaType.ALL)
                .retrieve()
                .bodyToFlux(Integer.class);

        final List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());
        longFlux
                .log()
                .subscribe(numbers::add);

        sleep(4000);
        numbers.forEach(System.out::println);
    }
}
