package com.reactor.backpressure.client;

import com.reactor.backpressure.server.person.Person;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

public class ReactiveClient<T> {
    public List<T> getList(Class classType, String url, String entryPoint) {
        WebClient webClient = WebClient.create(url);
        Flux<T> namesFlux = webClient.get().uri(entryPoint)
                .accept(MediaType.ALL)
                .retrieve()
                .bodyToFlux(classType);

        List<T> list = namesFlux
                .collectList()
                .block();

        return list;
    }
}
