package sk.posam.fsa.boot.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.posam.fsa.boot.application.repositories.ActorCrudRepository;
import sk.posam.fsa.boot.application.repositories.FilmCrudRepository;
import sk.posam.fsa.boot.domain.Actor;

import java.util.List;

@RestController
public class RestApiController {

    @Autowired
    private ActorCrudRepository actorRepository;

    @Autowired
    private FilmCrudRepository filmRepository;


    @GetMapping("/actors/{id}")
    Actor one(@PathVariable Long id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
    }

    @GetMapping("/actors")
    Iterable<Actor> all() {
        return actorRepository.findAll();
    }

    @PostMapping("/actors")
    Actor newActor(@RequestBody Actor newActor) {
        return actorRepository.save(newActor);
    }

    @PutMapping("/actors/{id}")
    Actor replaceActor(@RequestBody Actor newActor, @PathVariable Long id) {

        return actorRepository.findById(id)
                .map(actor -> {
                    actor.setFirstName(newActor.getFirstName());
                    actor.setLastName(newActor.getLastName());
                    return actorRepository.save(actor);
                })
                .orElseGet(() -> {
                    newActor.setId(id);
                    return actorRepository.save(newActor);
                });
    }

    @DeleteMapping("/actors/{id}")
    void deleteActor(@PathVariable Long id) {
        actorRepository.deleteById(id);
    }
}
