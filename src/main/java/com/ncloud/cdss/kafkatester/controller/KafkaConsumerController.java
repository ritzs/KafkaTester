package com.ncloud.cdss.kafkatester.controller;

import com.ncloud.cdss.kafkatester.service.KafkaConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaConsumerController{

    private final KafkaConsumerService kafkaConsumerService;

    @GetMapping("/getKafkaDataLast")
    public String getKafkaData() {

        String data = kafkaConsumerService.getReceivedData();

        if (data != null) {
            return "Received Kafka data: " + data;
        } else {
            return "No Kafka data received yet.";
        }
    }
}