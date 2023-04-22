package sk.posam.fsa.boot.application.assembler;

import sk.posam.fsa.boot.api.ActorDto;
import sk.posam.fsa.boot.domain.Actor;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ActorAssembler {
    public Collection<ActorDto> toDto(Iterable<Actor> actors) {
        return StreamSupport.stream(actors.spliterator(), false)
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public ActorDto toDto(Actor actor) {
        ActorDto result = new ActorDto();

        result.id = actor.getId();
        result.firstName = actor.getFirstName();
        result.lastName = actor.getLastName();
        result.lastUpdated = actor.getLastUpdated();
        result.films = new FilmAssembler().toDto(actor.getFilms());

        return result;
    }

    public Actor fromDto(ActorDto dto){
        Actor result = new Actor();

        result.setId(dto.id);
        result.setFirstName(dto.firstName);
        result.setLastName(dto.lastName);
        result.setLastUpdated(dto.lastUpdated);

        return result;
    }
}
