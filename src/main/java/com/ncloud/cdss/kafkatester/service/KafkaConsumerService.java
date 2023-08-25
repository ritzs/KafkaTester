package com.ncloud.cdss.kafkatester.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {

    private String receivedData = null;

    private static final String TOPIC_NAME = "test"; // 실제 토픽 이름으로 대체해주세요

    // group-Id 를 원하는 이름으로 대체해주세요 미입력시
    @KafkaListener(topics = TOPIC_NAME, groupId = "my-group", id = "listener1")
    private void consumeMessage(String message) {
        System.out.println("Received message from Kafka: " + message);
        this.receivedData = message;
    }

    public String getReceivedData(){
        return receivedData;
    }

}