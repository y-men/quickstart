package quickstart.javareactivewebmondodb.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quickstart.javareactivewebmondodb.domain.Movie;
import quickstart.javareactivewebmondodb.domain.MovieEvent;
import quickstart.javareactivewebmondodb.repositories.MovieRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {


    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    /**
     * Emit events for movie of specific id
     */
    public Flux<MovieEvent> events(String movieId) {

        Flux<MovieEvent> movieEventFlux = Flux.<MovieEvent>generate(
                sink -> {
                    sink.next(new MovieEvent(movieId, new Date()));
                }
// Emit events every 1 second
        ).delayElements(Duration.ofSeconds(1L));
        return movieEventFlux;
    }


    // --------------------------------
    @Override
    public Mono<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Flux<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

}
