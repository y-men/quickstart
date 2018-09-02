package quickstart.javareactivewebmondodb.service;

import quickstart.javareactivewebmondodb.domain.Movie;
import quickstart.javareactivewebmondodb.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    public Mono<Movie> getMovieById ( String id);
    public Flux< Movie> getAllMovies ();
    public Flux <MovieEvent> events ( String movieId);
}
