package com.example.demo.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TicketKafkaConsumer {
    public static final String TOPIC = "tickets_topic";

    @KafkaListener(topics = TOPIC, groupId = "my-group")
    public void listen(String message) {
        System.out.println("TicketKafkaConsumer recibió el mensaje: "+message);
    }

}
