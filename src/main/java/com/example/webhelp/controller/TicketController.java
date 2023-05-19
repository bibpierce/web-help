package com.example.webhelp.controller;

import com.example.webhelp.model.Ticket;
import com.example.webhelp.service.EmployeeService;
import com.example.webhelp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/create")
    public ResponseEntity createTicket(@RequestBody Ticket ticket){
        ticketService.createTicket(ticket);
        return new ResponseEntity<>("ticket created", HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Ticket>> listTickets(){
        return new ResponseEntity<>(ticketService.listTickets(), HttpStatus.OK);
    }
}
