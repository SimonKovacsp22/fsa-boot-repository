package sk.posam.fsa.boot.application.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.boot.domain.Actor;
import sk.posam.fsa.boot.domain.Film;

public interface FilmCrudRepository extends CrudRepository<Film, Long> {
}
