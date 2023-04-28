package sk.posam.fsa.boot.application.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sk.posam.fsa.boot.domain.Play;

import java.util.Optional;
@Repository
public interface PlayCrudRepository extends CrudRepository<Play,Long> {
    @Transactional
    @Query("SELECT p FROM Play p WHERE p.Id = ?1")
    Optional<Play> findPlayById(Long id);
}
