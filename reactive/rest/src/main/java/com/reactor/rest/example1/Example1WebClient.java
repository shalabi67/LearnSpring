package com.reactor.rest.example1;

import com.reactor.rest.models.Person;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
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

        final List<Person> people = new ArrayList<>();

        /*
        namesFlux
                .log()
                .subscribe(people::add);
        */
        namesFlux
                .log()
                .subscribe(new Subscriber<Person>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        subscription.request(20);
                    }

                    @Override
                    public void onNext(Person person) {
                        System.out.println(person.getFirstName());
                        people.add(person);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });

        sleep(500);
        people.forEach(person -> System.out.println(person.getFirstName() + "  " + person.getLastName()));
    }
    private static void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
