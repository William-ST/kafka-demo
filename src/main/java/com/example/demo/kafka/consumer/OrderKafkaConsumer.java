package com.example.demo.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderKafkaConsumer {
    public static final String TOPIC = "orders_topic";

    @KafkaListener(topics = TOPIC, groupId = "my-group")
    public void listen(String message) {
        System.out.println("OrderKafkaConsumer recibió el mensaje: "+message);
    }

}
