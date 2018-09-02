package qs.rabbitmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import qs.rabbitmq.domain.Product;
import qs.rabbitmq.repositories.ProductRepository;

import java.util.Map;

@Component
@Slf4j
public class ProductMessageListener {

    private final ProductRepository productRepository;


    //Autowire
    public ProductMessageListener(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**
     * Invoked when new message added to Queue
     * @param message
     */
    public void receiveMessage(Map<String, String> message) {
        log.debug(" >>>>> Message received :" + message);
        Long id = Long.valueOf(message.get("id"));
        Product product = productRepository.findById(id).orElse(null);
        product.setMessageReceived(true);
        product.setMessageCount(product.getMessageCount() + 1);

        productRepository.save(product);

        log.debug(" >>>>> Updated message :" + message);
    }
}
