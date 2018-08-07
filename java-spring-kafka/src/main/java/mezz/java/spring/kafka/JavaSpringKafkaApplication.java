package mezz.java.spring.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class JavaSpringKafkaApplication
implements ApplicationListener <ApplicationReadyEvent>
{

    public static final Logger l = LoggerFactory.getLogger(JavaSpringKafkaApplication.class );
    public static void main(String[] args) {
        SpringApplication.run(JavaSpringKafkaApplication.class, args);
    }


    @KafkaListener( topics = "q")
    public void  onMessage (ConsumerRecord<?,?> consumerRecord) {
        l.debug(">> onMessage ");
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        l.debug(">> CONTEXT CREATED... ");

    }
}
