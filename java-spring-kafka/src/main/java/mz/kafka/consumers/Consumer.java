package mz.kafka.consumers;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@NoArgsConstructor
public class Consumer {


    private String results;

    @KafkaListener(topics = "q")
    public void onMessage(ConsumerRecord<?, ?> consumerRecord) {
        log.debug("ON MESSAGE");
        log.debug(recordInfo(consumerRecord));
        results = String.valueOf(consumerRecord.value());
    }


    public Object getResults() {
        return results;
    }


    /**
     * Display nice representation of the result
     *
     * @param consumerRecord
     * @return
     */
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
                ).substring(0, 20)));

        return s;
    }
}
