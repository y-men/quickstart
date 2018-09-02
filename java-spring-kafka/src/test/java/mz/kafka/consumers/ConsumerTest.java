package mz.kafka.consumers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
//@EmbeddedKafka(
//        partitions = 1,
//        topics = {"q"}
//)

/**
 * Not sure how such Kakfka test contrubute...
 */
public class ConsumerTest {

    private static final String RECEIVER_TOPIC = "q";
    @ClassRule
    public static KafkaEmbedded kafkaEmbedded = new KafkaEmbedded(1,
            true,
            RECEIVER_TOPIC);

    @Autowired
    private Consumer consumer;

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;


    @Before
    public void setUp() throws Exception {
        // set up the Kafka producer properties
        Map<String, Object> senderProperties =
                KafkaTestUtils.senderProps(kafkaEmbedded.getBrokersAsString());

        // create a Kafka producer factory
        ProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<String, String>(senderProperties);

        // create a Kafka template
        kafkaTemplate = new KafkaTemplate<>(producerFactory);
        // set the default topic to send to
        kafkaTemplate.setDefaultTopic(RECEIVER_TOPIC);

        // wait until the partitions are assigned
        for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
                .getListenerContainers()) {
            ContainerTestUtils.waitForAssignment(messageListenerContainer,
                    kafkaEmbedded.getPartitionsPerTopic());
        }
    }

    @Test
    public void testReceive() throws Exception {
        // send the message
        String greeting = "Hello Spring Kafka Receiver!";
        kafkaTemplate.sendDefault(greeting);
        log.debug("test-sender sent message='{}'", greeting);

//        consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
//        // check that the message was received
//        assertThat(receiver.getLatch().getCount()).isEqualTo(0);
    }

}