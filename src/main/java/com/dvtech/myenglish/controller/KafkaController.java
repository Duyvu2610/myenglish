package com.dvtech.myenglish.controller;

import com.dvtech.myenglish.kafka.KafkaMessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaMessageProducer kafkaMessageProducer;

    public KafkaController(KafkaMessageProducer kafkaMessageProducer) {
        this.kafkaMessageProducer = kafkaMessageProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String message) {
        kafkaMessageProducer.sendWordEvent(message);
        return ResponseEntity.ok("Message sent to Kafka");
    }
}
