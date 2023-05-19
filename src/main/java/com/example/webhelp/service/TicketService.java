package com.example.webhelp.service;

import com.example.webhelp.model.Ticket;

import java.util.List;

public interface TicketService {

    void createTicket(Ticket ticket);

    List<Ticket> listTickets();
}
