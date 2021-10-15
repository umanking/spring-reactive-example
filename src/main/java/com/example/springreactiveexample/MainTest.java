package com.example.springreactiveexample;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MainTest {

    public static void main(String[] args) {
        // mono
        Mono<String> mono = Mono.just("my first mono publish");
        mono.subscribe(new MyMonoSubscriber());

        System.out.println("=======");

        // flux
        Flux<String> flux = Flux.just("a", "b", "c", "d");
        flux.subscribe(new MyFluxSubscriber());

        // flux -error
        System.out.println("=======");
        Flux.just("a", "b")
                .filter(val -> val.equals("c"))
                .switchIfEmpty(Flux.error(new RuntimeException("Something Wrong")))
                .subscribe(new MyFluxSubscriber());

    }

}
