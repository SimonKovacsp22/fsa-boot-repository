package sk.posam.fsa.boot.application.assembler;

import sk.posam.fsa.boot.api.FilmDto;
import sk.posam.fsa.boot.domain.Film;

import java.util.Set;
import java.util.stream.Collectors;

public class FilmAssembler {
    public Set<FilmDto> toDto(Set<Film> films) {
        return films.stream()
                .map(this::toDto)
                .collect(Collectors.toSet());
    }

    public FilmDto toDto(Film film) {
        FilmDto result = new FilmDto();

        result.id = film.getId();
        result.title = film.getTitle();
        result.description = film.getDescription();
        result.releaseYear = film.getReleaseYear();
        result.length = film.getLength();
        result.lastUpdated = film.getLastUpdated();

        return result;
    }
}
