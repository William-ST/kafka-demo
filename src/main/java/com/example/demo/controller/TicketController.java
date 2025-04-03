package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        logger.error("Error processing request: {}", e.getMessage(), e);
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> submitTicket(@RequestBody Ticket ticket) {
        try {
            Ticket createdTicket = ticketService.submitTicket(ticket);
            return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            logger.error("Test Failed to create ticket: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

}