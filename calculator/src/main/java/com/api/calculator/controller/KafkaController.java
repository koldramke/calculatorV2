package com.api.calculator.controller;

import com.api.calculator.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        kafkaProducerService.sendMessage("example-topic", message);
        System.out.println("MESSAGE SENT TO TOPIC: " + message);
        return "MESSAGE SUCCESSFULLY SENT: " + message;
    }
}
