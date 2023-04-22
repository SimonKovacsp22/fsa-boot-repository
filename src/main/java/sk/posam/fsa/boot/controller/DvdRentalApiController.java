package sk.posam.fsa.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sk.posam.fsa.boot.api.ActorDto;
import sk.posam.fsa.boot.api.DvdRentalApi;
import sk.posam.fsa.boot.application.DvdRentalApiService;

import java.util.Collection;

@RestController
public class DvdRentalApiController implements DvdRentalApi {

    @Autowired
    private DvdRentalApiService apiService;

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
}
