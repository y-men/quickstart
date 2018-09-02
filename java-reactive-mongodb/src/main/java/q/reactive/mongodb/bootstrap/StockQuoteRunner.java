package q.reactive.mongodb.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import q.reactive.mongodb.domain.Quote;
import q.reactive.mongodb.web.StockQuoteClient;
import reactor.core.publisher.Flux;

//@Component
public class StockQuoteRunner implements CommandLineRunner {

    private final StockQuoteClient stockQuoteClient;

    public StockQuoteRunner(StockQuoteClient stockQuoteClient) {
        this.stockQuoteClient = stockQuoteClient;
    }

    @Override
    public void run(String... args) throws Exception {
        Flux<Quote> quoteFlux = stockQuoteClient
                .getQuoteStream();
                //.log();

        quoteFlux.subscribe(System.out::println);
    }
}
