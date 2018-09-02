package mz.kafka;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest

/**
 * Integration test for the messaging classes
 *
 * TODO
 * - Topic with multiple comsumers
 * - Once and only once topic
 * - Display the partition
 * - HA
 */
public class JavaSpringKafkaApplicationTests {

    //TODO Use kafka embedded

    @Autowired
    private KafkaTemplate <String,String> kafkaTemplate;

    @Test
   public void testSimpleMessage() {
        // Send message to topic=q in Kafka

        log.debug(">> testSimpleMessage send");
        kafkaTemplate.send("q","THIS IS A TEST MESSAGE");

        // Need to ensure the results are written into some storage and then assers from there...
        //assertNotNull( );

    }

}
