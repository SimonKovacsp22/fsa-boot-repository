package sk.posam.fsa.boot.domain.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.posam.fsa.boot.application.repository.ActorCrudRepository;
import sk.posam.fsa.boot.application.repository.PlayCrudRepository;
import sk.posam.fsa.boot.domain.Actor;
import sk.posam.fsa.boot.domain.Play;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class PlayRepositoryImpl implements PlayRepository{
    @Autowired
    private PlayCrudRepository playCrudRepository;
    @Autowired
    ActorCrudRepository actorCrudRepository;
    @Override
    public Play read(long id) {
        Optional<Play> play = playCrudRepository.findPlayById(id);
        return play.orElse(null);
    }

    @Override
    public void addActorToPlay(String lastName, long playId) {
        List<Actor> actorsInPlay= new ArrayList<>(List.of(new Actor("Andrew","Garfield", Date.from(Instant.now()))));
        Play hamlet = new Play("Hamlet", actorsInPlay, LocalTime.of(1,0));
        Play play = playCrudRepository.findById(playId).orElseThrow(() -> new EntityNotFoundException("Play not found with id " + 3L));
        List<Actor> actorsWithPaltrow = actorCrudRepository.findByLastName(lastName);
        if(actorsWithPaltrow.size() > 0){
            Actor actor = actorsWithPaltrow.get(0);
            play.addActor(actor);
            actor.addPlay(play);
            playCrudRepository.save(play);
            actorCrudRepository.save(actor);
        }

    }

    @Override
    public void deletePlay(long id) {
        playCrudRepository.deleteById(id);
    }

    @Override
    public Play createPlay(String name, LocalTime duration) {
        Play play = new Play(name,duration);
        return playCrudRepository.save(play);
    }
}
