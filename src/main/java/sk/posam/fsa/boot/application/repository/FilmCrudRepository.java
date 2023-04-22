package sk.posam.fsa.boot.application.repository;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.boot.domain.Film;

public interface FilmCrudRepository extends CrudRepository<Film, Long> {
}
