package com.ncloud.cdss.kafkatester.controller;

import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${cdss.topic-name}")
    String cdssTopicName;
    private static final String TOPIC_NAME = "test"; // 실제 토픽 이름으로 대체해주세요


    @Async
    @PostMapping("/produceAuto")
    public void postProduceMessage(){
        for (int counter = 1; counter <= 1000000; counter++) {

            LocalDateTime currentTime = LocalDateTime.now();
            String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            long threadId = Thread.currentThread().getId(); // 현재 쓰레드의 ID를 얻음
            String message = "내가 보낸 메시지 " + counter + " - " + formattedTime + " - Thread ID: " + threadId;

            kafkaTemplate.send(TOPIC_NAME, message);
            System.out.println("Message sent to Kafka: " + message);
            try {
                Thread.sleep(300); // 3초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //return "Messages are being sent to Kafka asynchronously. Check console for details.";
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