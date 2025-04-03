package com.example.demo.service;

import com.example.demo.kafka.consumer.OrderKafkaConsumer;
import com.example.demo.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public OrderService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Order submitOrder(Order order) {
        order.setId(UUID.randomUUID().toString());
        order.setNro(UUID.randomUUID().toString().substring(0, 8));
        try {
            System.out.println("submitOrder (KafkaTemplate) order: "+order);
            kafkaTemplate.send(OrderKafkaConsumer.TOPIC, "Ha llegado una nueva orden: " + order);
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        return order;
    }
}
