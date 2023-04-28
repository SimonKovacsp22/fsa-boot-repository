package sk.posam.fsa.boot.domain.repositories;

import sk.posam.fsa.boot.domain.Play;

import java.time.LocalTime;

public interface PlayRepository {
    Play read(long id);

    void addActorToPlay(String lastName, long playId);

    void deletePlay(long id);

    Play createPlay(String name, LocalTime duration);
}
