package q.spring.webflux.service;

import org.springframework.stereotype.Service;
import q.spring.webflux.model.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;


//@Service
public interface QuoteGeneratorService {
    Flux<Quote> fetchQuoteStream(Duration period);

}
