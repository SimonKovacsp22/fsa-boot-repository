package sk.posam.fsa.boot.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.posam.fsa.boot.application.repositories.ActorCrudRepository;
import sk.posam.fsa.boot.application.repositories.FilmCrudRepository;
import sk.posam.fsa.boot.domain.Actor;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class RestApiController {

    @Autowired
    private ActorCrudRepository actorRepository;

    @Autowired
    private FilmCrudRepository filmRepository;


    @GetMapping("/actors/{id}")
    Actor one(@PathVariable Long id) {
        Optional<Actor> actor = actorRepository.findById(id);
        return actor.orElseThrow(() -> new EntityNotFoundException());
    }

    //http://localhost:8080/v1/actors?priezvisko=
    @GetMapping("/actors")
    Iterable<Actor> all(@RequestParam(name="priezvisko", required = false) String lastNameFilter) {
        if(lastNameFilter==null||lastNameFilter.isBlank()){
            return actorRepository.findAll();
        }
        else{
            return actorRepository.findByLastName(lastNameFilter);
        }
    }


    @PostMapping("/actors")
    Actor newActor(@RequestBody Actor newActor) {
        newActor.setLastUpdated(new Date());
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
