package com.dvtech.myenglish.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String wordEventsTopic;

    public KafkaMessageProducer(
            KafkaTemplate<String, String> kafkaTemplate,
            @Value("${kafka.topic.word-events}") String wordEventsTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.wordEventsTopic = wordEventsTopic;
    }

    public void sendWordEvent(String message) {
        kafkaTemplate.send(wordEventsTopic, message);
    }
}
