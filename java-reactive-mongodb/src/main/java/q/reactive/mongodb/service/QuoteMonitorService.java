package q.reactive.mongodb.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import q.reactive.mongodb.domain.Quote;
import q.reactive.mongodb.repository.QuoteRepository;
import q.reactive.mongodb.web.StockQuoteClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class QuoteMonitorService implements ApplicationListener<ContextRefreshedEvent> {


    private final StockQuoteClient stockQuoteClient;
    private final QuoteRepository quoteRepository;

    public QuoteMonitorService(StockQuoteClient stockQuoteClient, QuoteRepository quoteRepository) {
        this.stockQuoteClient = stockQuoteClient;
        this.quoteRepository = quoteRepository;
    }

    //-----------------

    // The 'clsssic' spring way of starting up application
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug(">>>>>>>>>>>>>>>" + "onApplicationEvent");

        //Stream the quotes into mongodb
        stockQuoteClient.getQuoteStream()
                .log("quote-monitor-service")
                .subscribe(quote -> {
                    log.debug(" ~~~~~~~~~~~~~~~" +quote);
                    Mono<Quote> quoteMono = quoteRepository.save(quote);
                   // System.out.println(" >>>>>>>>   Saved a quote: " + quoteMono.block().getId());
                    //+ quoteMono..block().getId());

                    //String s = quoteMono.block().getId();

                });
    }
}
