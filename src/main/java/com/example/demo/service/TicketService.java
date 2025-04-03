package com.example.demo.service;

import com.example.demo.kafka.consumer.TicketKafkaConsumer;
import com.example.demo.model.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketService {

    private static final Logger logger = LoggerFactory.getLogger(TicketService.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public TicketService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Ticket submitTicket(Ticket ticket) {
        ticket.setId(UUID.randomUUID().toString());
        ticket.setNro(UUID.randomUUID().toString().substring(0, 8));
        try {
            System.out.println("submitTicket (KafkaTemplate) ticket: "+ticket);
            kafkaTemplate.send(TicketKafkaConsumer.TOPIC, "Ha llegado un nuevo ticket: " + ticket);
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        return ticket;
    }
}
