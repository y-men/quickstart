package quickstart.javareactivewebmondodb.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quickstart.javareactivewebmondodb.domain.Movie;
import quickstart.javareactivewebmondodb.domain.MovieEvent;
import quickstart.javareactivewebmondodb.service.MovieService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 */

@Slf4j
@RestController
@RequestMapping("/movies")

/*
TODO
- [] Add swagger support
 */
public class MovieController {


    private final MovieService movieService;

    // @Autowire
    public MovieController(MovieService s) {
        this.movieService = s;
    }


    @GetMapping ( value = "/{id}")
    public Mono<Movie> getMovieById(@PathVariable  String id) {
        return movieService.getMovieById(id);
    }

    @GetMapping
    public Flux<Movie> all() {
        return movieService.getAllMovies();
    }

    @GetMapping ( value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovieEvent> events(@PathVariable  String id) {
        return movieService.events( id);
    }
}
