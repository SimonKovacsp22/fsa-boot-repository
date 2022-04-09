package sk.posam.fsa.boot.application.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.posam.fsa.boot.domain.Actor;
import sk.posam.fsa.boot.domain.Film;
import sk.posam.fsa.boot.domain.FilmArchiveService;
import sk.posam.fsa.boot.domain.repositories.ActorRepository;
import sk.posam.fsa.boot.domain.repositories.FilmRepository;

@Service
public class FilmArchiveServiceImpl implements FilmArchiveService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Override
//    @Transactional
    public boolean hralHerecVoFilme(long actorId, long filmId) {
        Actor actor = actorRepository.read(actorId);
        Film film = filmRepository.read(filmId);
        return film.getActors().contains(actor);
    }

}
