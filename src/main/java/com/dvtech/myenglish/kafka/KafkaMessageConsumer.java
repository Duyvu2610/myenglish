package com.dvtech.myenglish.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaMessageConsumer {

    @KafkaListener(topics = "${kafka.topic.word-events}")
    public void listenWordEvents(String message) {
        log.info("Received Kafka message from word-events: {}", message);
    }

    @KafkaListener(
            topics = "${kafka.topic.test}",
            groupId = "${kafka.consumer-group.test}")
    public void listenTestTopic(String message) {
        log.info("Received Kafka message from test topic: {}", message);
    }
}
