package com.ncloud.cdss.kafkatester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaTesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaTesterApplication.class, args);
    }

}
