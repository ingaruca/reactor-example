package com.ingarucadev.operador.creacion;

import com.ingarucadev.DemoReactorApplication;
import com.ingarucadev.model.Persona;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Creacion {

  private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

  public void justFrom() {
    Mono.just(new Persona(1, "Luis", 27));
    //Flux.fromIterable(coleccion);
    //Observable.just(item);
  }

  public void empty() {
    Mono.empty();
    Flux.empty();
    Observable.empty();
  }

  public void range() {
    Flux.range(0, 3)
            .doOnNext(i -> log.info("i: " + i))
            .subscribe();
  }

  public void repeat() {
    List<Persona> personas = new ArrayList<>();
    personas.add(new Persona(1, "Eva", 59));
    personas.add(new Persona(2, "Clember", 59));
    personas.add(new Persona(3, "Alfredo", 22));

    Flux.fromIterable(personas)
            .repeat(3)
            .subscribe(p -> log.info(p.toString()));

    /*Mono.just(new Persona(1, "Alfredo", 22))
            .repeat(3)
            .subscribe(p -> log.info(p.toString()));*/
  }

}
