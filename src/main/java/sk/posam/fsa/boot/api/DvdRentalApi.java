package sk.posam.fsa.boot.api;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/v1")
public interface DvdRentalApi {

    @GetMapping("/actors/{id}")
    ActorDto one(@PathVariable Long id);

    //http://localhost:8081/v1/actors?priezvisko=
    @GetMapping("/actors")
    Collection<ActorDto> all(@RequestParam(name = "priezvisko", required = false) String lastNameFilter);

    @PostMapping("/actors")
    long newActor(@RequestBody ActorDto newActor);

    @PutMapping("/actors/{id}")
    void replaceActor(@RequestBody ActorDto newActor, @PathVariable Long id);

    @DeleteMapping("/actors/{id}")
    void deleteActor(@PathVariable Long id);

    //http://localhost:8081/v1/actors/55/hral-vo-filme?filmId=55
    @GetMapping("/actors/{id}/hral-vo-filme")
    boolean hralHerecVoFilme(@PathVariable(name = "id") long actorId, @RequestParam long filmId);

}