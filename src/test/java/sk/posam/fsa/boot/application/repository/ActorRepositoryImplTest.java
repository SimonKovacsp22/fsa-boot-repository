package sk.posam.fsa.boot.application.repository;

import org.junit.jupiter.api.Test;
import sk.posam.fsa.boot.domain.repositories.ActorRepository;

class ActorRepositoryImplTest {

    @Test
    public void testRead() {
        ActorRepository repo = new ActorRepositoryImpl();
//        Assertions.assertNotNull(repo.read(2));
    }

}