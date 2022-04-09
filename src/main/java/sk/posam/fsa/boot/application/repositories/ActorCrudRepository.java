package sk.posam.fsa.boot.application.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.boot.domain.Actor;

import java.util.List;

public interface ActorCrudRepository extends CrudRepository<Actor, Long> {
    List<Actor> findByLastName(String lastName);
}
