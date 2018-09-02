package q.reactive.mongodb.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import q.reactive.mongodb.domain.Quote;

public interface QuoteRepository extends ReactiveMongoRepository <Quote, String> {
}
