package sk.posam.fsa.boot.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sk.posam.fsa.boot.domain.Actor;

import java.util.Date;
import java.util.Set;

public class FilmDto {

    public Long id;

    public String title;

    public String description;

    public Integer releaseYear;

    public Integer length;

    @JsonIgnore
    public Set<Actor> actors;

    public Date lastUpdated;

}
