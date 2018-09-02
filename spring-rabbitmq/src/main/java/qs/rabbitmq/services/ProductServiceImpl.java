package qs.rabbitmq.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import qs.rabbitmq.RabbitmqApplication;
import qs.rabbitmq.repositories.ProductRepository;

import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;
    private RabbitTemplate rabbitTemplate;


    public ProductServiceImpl(ProductRepository productRepository, RabbitTemplate rabbitTemplate) {
        this.productRepository = productRepository;
        this.rabbitTemplate = rabbitTemplate;
    }



    @Override
    public void sendProductMessage(String id) {
        Map<String, String> actionmap = new HashMap<>();
        actionmap.put("id", id);
        log.info("Sending the index request through queue message");
        rabbitTemplate.convertAndSend(RabbitmqApplication.MQ, actionmap);

    }
}
