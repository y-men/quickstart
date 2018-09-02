package quickstart.javareactivewebmondodb.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import quickstart.javareactivewebmondodb.domain.Movie;
import quickstart.javareactivewebmondodb.repositories.MovieRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Slf4j
@Component
public class BootstrapCLR implements CommandLineRunner {

    private MovieRepository movieRepository;

    //@Autowired
    public BootstrapCLR(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(" BOOTSTRAP STARTED");

        // Add new data into MondoDb ( embedded )
        movieRepository.deleteAll().block();
        Flux.just(
                "My Movie #1",
                "My Movie #2",
                "My Movie #3",
                "My Movie #4",
                "My Movie #5"

        )
                .map(title -> new Movie(UUID.randomUUID().toString(), title))
                .flatMap(movieRepository::save) // Try refactor to lambda
                //     .subscribe(System.out::println);  It works but not reading from Mongo
                .subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(System.out::println);
                });

    }
}
