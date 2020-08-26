package com.ingarucadev;

import com.ingarucadev.model.Persona;
import com.ingarucadev.operador.creacion.Creacion;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

  private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

  public void reactor() {
    Mono.just(new Persona(1, "Luis", 27))
            .doOnNext(p -> {
              // logica adicional
              log.info("[Reactor] Persona: " + p);
            })
            .subscribe(p -> log.info("[Reactor] Persona: " + p));
  }

  public void rxjava2() {
    Observable.just(new Persona(1, "Luis", 27))
            .doOnNext(p -> log.info("[RxJava2] Persona: " + p))
            .subscribe(p -> log.info("[RxJava2] Persona: " + p));
  }

  public void mono() {
    Mono.just(new Persona(1, "Angelica", 4))
            .subscribe(p -> log.info(p.toString()));
  }

  public void flux() {
    List<Persona> personas = new ArrayList<>();
    personas.add(new Persona(1, "Eva", 59));
    personas.add(new Persona(2, "Clember", 59));
    personas.add(new Persona(3, "Alfredo", 22));

    Flux.fromIterable(personas)
            .subscribe(p -> log.info(p.toString()));
  }

  public void fluxMono() {
    List<Persona> personas = new ArrayList<>();
    personas.add(new Persona(1, "Eva", 59));
    personas.add(new Persona(2, "Clember", 59));
    personas.add(new Persona(3, "Alfredo", 22));

    Flux<Persona> fx = Flux.fromIterable(personas);
    fx.collectList().subscribe(lista -> log.info(lista.toString()));
  }

  public static void main(String[] args) {
    SpringApplication.run(DemoReactorApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Creacion app = new Creacion();
    app.repeat();
  }
}
