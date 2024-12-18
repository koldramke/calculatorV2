package com.api.calculator.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "example-topic", groupId = "group_id")
    public void listen(String message) {
        System.out.println("MESSAGE SENT:" + message);
    }
}
