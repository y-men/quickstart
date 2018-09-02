package quickstart.javareactivewebmondodb.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import quickstart.javareactivewebmondodb.domain.Movie;

/**
 *
 */
public interface MovieRepository extends ReactiveMongoRepository<Movie,String> {
}
