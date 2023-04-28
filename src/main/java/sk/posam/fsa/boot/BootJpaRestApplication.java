package sk.posam.fsa.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sk.posam.fsa.boot.application.repository.ActorCrudRepository;
import sk.posam.fsa.boot.application.repository.PlayCrudRepository;
import sk.posam.fsa.boot.domain.FilmArchiveService;

import javax.sql.DataSource;

@SpringBootApplication
public class BootJpaRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootJpaRestApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(FilmArchiveService filmArchiveService, DataSource dataSource, PlayCrudRepository playRepository, ActorCrudRepository actorRepository) {
        return (args) -> {




        };
    }

}
