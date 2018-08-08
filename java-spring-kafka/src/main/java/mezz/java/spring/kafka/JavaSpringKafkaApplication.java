package mezz.java.spring.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class JavaSpringKafkaApplication
        implements CommandLineRunner,
        ApplicationListener<ApplicationReadyEvent> {


    public static final Logger l = LoggerFactory.getLogger(JavaSpringKafkaApplication.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(JavaSpringKafkaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        kafkaTemplate.send("q", "OK OK OK");
    }

    @KafkaListener(topics = "q")
    public void onMessage(ConsumerRecord<?, ?> consumerRecord) {
        l.debug(recordInfo(consumerRecord));
    }

    private String recordInfo(ConsumerRecord<?, ?> consumerRecord) {
        String leftAlignFormat = "| %-15s | %-20s |%n";

        String s = String.format("%n+-----------------+----------------------+%n")
                .concat(String.format("|  name           | value                |%n"))
                .concat(String.format("+-----------------+----------------------+%n"))

                .concat(String.format(leftAlignFormat, "topic", String.valueOf(
                        consumerRecord.topic()
                )))

                .concat(String.format(leftAlignFormat, "value", String.valueOf(
                        consumerRecord.value()
                )));

        return s;

    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        l.debug(">> CONTEXT CREATED... ");

    }
}
