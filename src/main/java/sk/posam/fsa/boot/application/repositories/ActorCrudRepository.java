package sk.posam.fsa.boot.application.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.boot.domain.Actor;

public interface ActorCrudRepository extends CrudRepository<Actor, Long> {
}
