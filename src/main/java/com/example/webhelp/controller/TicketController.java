package com.example.webhelp.controller;

import com.example.webhelp.model.Ticket;
import com.example.webhelp.model.TicketDto;
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
    @GetMapping("/view")
    public ResponseEntity<Ticket> viewTicket(Long ticketNumber){
        return new ResponseEntity<>(ticketService.viewTicket(ticketNumber), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Ticket>> listTickets(){
        return new ResponseEntity<>(ticketService.listTickets(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateTicket(TicketDto ticketDto){
        ticketService.updateTicket(ticketDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{ticketNumber}")
    public ResponseEntity deleteTicket(@PathVariable Long ticketNumber){
        ticketService.deleteTicket(ticketNumber);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/watchers/{ticketNumber}")
    public ResponseEntity assignTicket(@PathVariable Long ticketNumber, @RequestParam List<Long> employeeNumbers){
        ticketService.assignWatchers(ticketNumber, employeeNumbers);
        return new ResponseEntity<>("Watchers Assigned to " + employeeNumbers,HttpStatus.OK);
    }
}
