package sk.posam.fsa.boot.application.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sk.posam.fsa.boot.domain.repositories.ActorRepository;

import static org.junit.jupiter.api.Assertions.*;

class ActorRepositoryImplTest {

    @Test
    public void testRead() {
        ActorRepository repo = new ActorRepositoryImpl();
//        Assertions.assertNotNull(repo.read(2));
    }

}