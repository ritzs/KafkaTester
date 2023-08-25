package com.ncloud.cdss.kafkatester.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC_NAME = "test"; // 실제 토픽 이름으로 대체해주세요

    @PostMapping("/produce")
    public String postProduceMessage(@RequestBody String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
        return "Message sent to Kafka: " + message;
    }

    @GetMapping("/produce")
    public String getProduceMessageRequestParam(@RequestParam String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
        return "Message sent to Kafka: " + message;
    }

    @GetMapping("/produce/{message}")
    public String getProduceMessagePathVariable(@PathVariable String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
        return "Message sent to Kafka: " + message;
    }
}