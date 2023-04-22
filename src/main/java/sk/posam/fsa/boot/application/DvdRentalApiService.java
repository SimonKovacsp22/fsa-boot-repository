package sk.posam.fsa.boot.application;

import sk.posam.fsa.boot.api.ActorDto;

import java.util.Collection;

public interface DvdRentalApiService {

    ActorDto getActorById(Long id);

    Collection<ActorDto> findActorsByLastName(String lastName);

    long createNewActor(ActorDto newActor);

    void replaceActor(ActorDto newActor, Long id);

    void deleteActor(Long id);

    boolean hralHerecVoFilme(long actorId, long filmId);

}
