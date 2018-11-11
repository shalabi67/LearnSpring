package com.reactor.backpressure.client;

import com.reactor.backpressure.server.person.Person;
import com.reactor.backpressure.server.person.PersonController;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BackPressure {
    private static int count = 0;
    private static int actualCount = 0;
    public static void main(String[] args) {

        String serverUrl = "http://localhost:8080";
        WebClient webClient = WebClient.create("http://localhost:8080");
        Flux<Person> namesFlux = webClient.get().uri(PersonController.URL)
                .accept(MediaType.ALL)
                .retrieve()
                .bodyToFlux(Person.class);

        List<Person> people1 = namesFlux
                .collectList()
                .block();

        people1.forEach(person -> System.out.println(person.getFirstName() + "  " + person.getLastName()));

        Flowable.interval(1, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer(100,
                        () -> doBackpressureDelay(),
                        BackpressureOverflowStrategy.DROP_LATEST)
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    ++count;
                    System.out.println("calling ..." + count);
                    ReactiveClient<Person> personClient = new ReactiveClient<>();
                    List<Person> people = personClient.getList(Person.class, serverUrl, PersonController.URL);
                    people.forEach(person -> System.out.println(person.getFirstName()));
                    actualCount++;
                });

        sleep(5000);
        System.out.println("Number of call = " + count + " actual=" + actualCount);
    }
    private static void doBackpressureDelay() {
        System.out.println("overflow!");
        sleep(20);
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
