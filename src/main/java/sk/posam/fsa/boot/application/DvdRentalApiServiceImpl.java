package sk.posam.fsa.boot.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.posam.fsa.boot.api.ActorDto;
import sk.posam.fsa.boot.application.assembler.ActorAssembler;
import sk.posam.fsa.boot.application.repository.ActorCrudRepository;
import sk.posam.fsa.boot.application.repository.FilmCrudRepository;
import sk.posam.fsa.boot.domain.Actor;
import sk.posam.fsa.boot.domain.FilmArchiveService;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Service
class DvdRentalApiServiceImpl implements DvdRentalApiService {

    @Autowired
    private FilmArchiveService filmArchiveService;

    @Autowired
    private ActorCrudRepository actorRepository;

    @Autowired
    private FilmCrudRepository filmRepository;

    private ActorAssembler actorAssembler = new ActorAssembler();


    @Override
    public ActorDto getActorById(Long id) {
        Optional<Actor> actor = actorRepository.findById(id);
        return actor.map(actorAssembler::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Collection<ActorDto> findActorsByLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) {
            return actorAssembler.toDto(actorRepository.findAll());
        } else {
            return actorAssembler.toDto(actorRepository.findByLastName(lastName));
        }
    }

    @Override
    public long createNewActor(ActorDto dto) {
        dto.lastUpdated = new Date();
        Actor newActor = actorRepository.save(actorAssembler.fromDto(dto));
        return newActor.getId();
    }

    @Override
    public void replaceActor(ActorDto newActor, Long id) {
        Optional<Actor> actorResult = actorRepository.findById(id);

        Actor actor;
        if (actorResult.isPresent()) {
            actor = actorResult.get();
            actor.setFirstName(newActor.firstName);
            actor.setLastName(newActor.lastName);
            actor.setLastUpdated(new Date());
        } else {
            newActor.id = id;
            actor = actorAssembler.fromDto(newActor);
        }

        actorRepository.save(actor);
    }

    @Override
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }

    @Override
    public boolean hralHerecVoFilme(long actorId, long filmId) {
        return filmArchiveService.hralHerecVoFilme(actorId, filmId);
    }
}
