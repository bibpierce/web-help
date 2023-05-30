package com.example.webhelp.service;

import com.example.webhelp.model.Employee;
import com.example.webhelp.model.Ticket;
import com.example.webhelp.model.TicketDto;

import java.util.List;

public interface TicketService {


    Ticket viewTicket(Long ticketNumber);

    void createTicket(Ticket ticket);

    List<Ticket> listTickets();

    void updateTicket(TicketDto ticketDto);

    void deleteTicket(Long ticketNumber);

    void assignWatchers(Long ticketNumber, List<Long> employeeNumbers);
}
