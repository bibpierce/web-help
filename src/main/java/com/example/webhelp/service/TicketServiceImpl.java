package com.example.webhelp.service;

import com.example.webhelp.model.Ticket;
import com.example.webhelp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public void createTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> listTickets() {
        return ticketRepository.findAll();
    }
}
