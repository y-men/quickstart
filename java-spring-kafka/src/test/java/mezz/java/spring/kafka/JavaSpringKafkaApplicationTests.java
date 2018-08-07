package mezz.java.spring.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaSpringKafkaApplicationTests {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaSpringKafkaApplicationTests.class);

    @Test
   public void testSimpleMessage() {
        // Send message to topic=q in Kafka

        LOGGER.debug(">> testSimpleMessage send");
        kafkaTemplate.send("q","THIS IS A TEST MESSAGE");
    }

}
