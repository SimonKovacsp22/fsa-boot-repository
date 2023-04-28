package sk.posam.fsa.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.boot.api.ActorDto;
import sk.posam.fsa.boot.api.DvdRentalApi;
import sk.posam.fsa.boot.api.PlayDto;
import sk.posam.fsa.boot.application.DvdRentalApiService;
import sk.posam.fsa.boot.domain.Play;
import sk.posam.fsa.boot.domain.repositories.PlayRepositoryImpl;

import java.util.Collection;

@RestController
public class DvdRentalApiController implements DvdRentalApi {

    @Autowired
    private DvdRentalApiService apiService;
    @Autowired
    private PlayRepositoryImpl playApiService;

    @Override
    public ActorDto one(Long id) {
        return apiService.getActorById(id);
    }

    @Override
    public Collection<ActorDto> all(String lastNameFilter) {
        return apiService.findActorsByLastName(lastNameFilter);
    }


    @Override
    public long newActor(ActorDto dto) {
        return apiService.createNewActor(dto);
    }

    @Override
    public void replaceActor(ActorDto dto, Long id) {
        apiService.replaceActor(dto, id);
    }

    @Override
    public void deleteActor(Long id) {
        apiService.deleteActor(id);
    }

    @Override
    public boolean hralHerecVoFilme(long actorId, long filmId) {
        return apiService.hralHerecVoFilme(actorId, filmId);
    }

    @Override
    public Play findPlayById(long id) {
        return playApiService.read(id);
    }

    @Override
    public void deletePlayById(long playId) {
         playApiService.deletePlay(playId);
    }

    @Override
    public Play createPlay(PlayDto play) {
       return playApiService.createPlay(play.name,play.duration);
    }

    @Override
    public void addActorToPlayById(String lastName, long playId) {
        playApiService.addActorToPlay(lastName,playId);
    }
}
