package sk.posam.fsa.boot.api;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
public interface DvdRentalApi {

    @GetMapping("/actors/{id}")
    ActorDto one(@PathVariable Long id);

    //http://localhost:8080/v1/actors?priezvisko=
    @GetMapping("/actors")
    Iterable<ActorDto> all(@RequestParam(name = "priezvisko", required = false) String lastNameFilter);


    @PostMapping("/actors")
    ActorDto newActor(@RequestBody ActorDto newActor);

    @PutMapping("/actors/{id}")
    ActorDto replaceActor(@RequestBody ActorDto newActor, @PathVariable Long id);

    @DeleteMapping("/actors/{id}")
    void deleteActor(@PathVariable Long id);
}
