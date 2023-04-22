package sk.posam.fsa.boot.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.boot.api.ActorDto;
import sk.posam.fsa.boot.api.DvdRentalApi;
import sk.posam.fsa.boot.application.assembler.ActorAssembler;
import sk.posam.fsa.boot.application.repository.ActorCrudRepository;
import sk.posam.fsa.boot.application.repository.FilmCrudRepository;
import sk.posam.fsa.boot.domain.Actor;

import java.util.Date;
import java.util.Optional;

@RestController
public class DvdRentalApiController implements DvdRentalApi {

    @Autowired
    private ActorCrudRepository actorRepository;

    @Autowired
    private FilmCrudRepository filmRepository;

    private ActorAssembler actorAssembler=new ActorAssembler();

    @Override
    public ActorDto one(Long id) {
        Optional<Actor> actor = actorRepository.findById(id);
        return actor.map(actorAssembler::toDto)
                .orElseThrow(() -> new EntityNotFoundException());
    }

    //http://localhost:8080/v1/actors?priezvisko=
    @Override
    public Iterable<ActorDto> all(String lastNameFilter) {
        if (lastNameFilter == null || lastNameFilter.isBlank()) {
            return actorAssembler.toDto(actorRepository.findAll());
        } else {
            return actorAssembler.toDto(actorRepository.findByLastName(lastNameFilter));
        }
    }


    @Override
    public ActorDto newActor(ActorDto dto) {
        dto.lastUpdated=new Date();
        Actor newActor = actorRepository.save(actorAssembler.fromDto(dto));
        return actorAssembler.toDto(newActor);
    }

    @Override
    public ActorDto replaceActor(ActorDto dto, Long id) {

        return actorRepository.findById(id)
                .map(actor -> {
                    actor.setFirstName(dto.firstName);
                    actor.setLastName(dto.lastName);
                    Actor newActor = actorRepository.save(actor);
                    return actorAssembler.toDto(newActor);
                })
                .orElseGet(() -> {
                    dto.id=id;
                    Actor newActor = actorRepository.save(actorAssembler.fromDto(dto));
                    return actorAssembler.toDto(newActor);
                });
    }

    @Override
    public void deleteActor( Long id) {
        actorRepository.deleteById(id);
    }
}
