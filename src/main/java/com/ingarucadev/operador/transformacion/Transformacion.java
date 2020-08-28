package com.ingarucadev.operador.transformacion;

import com.ingarucadev.DemoReactorApplication;
import com.ingarucadev.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Transformacion {

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void map() {
    /*List<Persona> personas = new ArrayList<>();
    personas.add(new Persona(1, "Eva", 59));
    personas.add(new Persona(2, "Clember", 59));
    personas.add(new Persona(3, "Alfredo", 22));

    Flux.fromIterable(personas)
            .map(p -> {
                p.setEdad(p.getEdad() + 10);
                return p;
            })
            .subscribe(p -> log.info(p.toString()));*/

        Flux<Integer> fx = Flux.range(0, 10);
        Flux<Integer> fx2 = fx.map(x -> x + 10);
        fx2.subscribe(x -> log.info("x: " + x));
    }

    public void flatMap() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Eva", 59));
        personas.add(new Persona(2, "Clember", 59));
        personas.add(new Persona(3, "Alfredo", 22));

        Flux.fromIterable(personas)
                .flatMap(p -> {
                    p.setEdad(p.getEdad() + 10);
                    return Mono.just(p);
                })
                .subscribe(p -> log.info(p.toString()));
    }

    public void groupBy() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Eva", 59));
        personas.add(new Persona(1, "Clember", 59));
        personas.add(new Persona(3, "Alfredo", 22));

        Flux.fromIterable(personas)
                .groupBy(Persona::getIdPersona)
                .flatMap(Flux::collectList)
                .subscribe(p -> log.info(p.toString()));
    }

}
