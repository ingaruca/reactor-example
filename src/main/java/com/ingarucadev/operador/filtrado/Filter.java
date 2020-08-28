package com.ingarucadev.operador.filtrado;

import com.ingarucadev.DemoReactorApplication;
import com.ingarucadev.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void filter() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Eva", 59));
        personas.add(new Persona(2, "Clember", 59));
        personas.add(new Persona(3, "Alfredo", 22));

        Flux.fromIterable(personas)
                .filter(p -> p.getEdad() > 50)
                .subscribe(p -> log.info(p.toString()));
    }

    public void distinct() {
        Flux.fromIterable(List.of(1,1,2,2))
                .distinct()
                .subscribe(n -> log.info(n.toString()));

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Eva", 59));
        personas.add(new Persona(1, "Clember", 59));
        personas.add(new Persona(3, "Alfredo", 22));

        Flux.fromIterable(personas)
                .distinct()
                .subscribe(p -> log.info(p.toString()));
    }

    public void take() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Eva", 59));
        personas.add(new Persona(2, "Clember", 59));
        personas.add(new Persona(3, "Alfredo", 22));

        Flux.fromIterable(personas)
                .take(2)
                .subscribe(p -> log.info(p.toString()));
    }

    public void takeLast() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Eva", 59));
        personas.add(new Persona(2, "Clember", 59));
        personas.add(new Persona(3, "Alfredo", 22));

        Flux.fromIterable(personas)
                .takeLast(2)
                .subscribe(p -> log.info(p.toString()));
    }

    public void skip() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Eva", 59));
        personas.add(new Persona(2, "Clember", 59));
        personas.add(new Persona(3, "Alfredo", 22));

        Flux.fromIterable(personas)
                .skip(1)
                .subscribe(p -> log.info(p.toString()));
    }

    public void skipLast() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Eva", 59));
        personas.add(new Persona(2, "Clember", 59));
        personas.add(new Persona(3, "Alfredo", 22));

        Flux.fromIterable(personas)
                .skipLast(2)
                .subscribe(p -> log.info(p.toString()));
    }

}
