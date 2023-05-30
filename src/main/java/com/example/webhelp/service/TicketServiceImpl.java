package com.example.webhelp.service;

import com.example.webhelp.model.Ticket;
import com.example.webhelp.model.TicketDto;
import com.example.webhelp.repository.EmployeeRepository;
import com.example.webhelp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Ticket viewTicket(Long ticketNumber) {
        return ticketRepository.findTicketByTicketNumber(ticketNumber);
    }

    @Override
    public void createTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> listTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public void updateTicket(TicketDto ticketDto) {
        Ticket ticket = ticketRepository.findTicketByTicketNumber(ticketDto.getTicketNumber());
        ticket.setTitle(ticketDto.getTitle());
        ticket.setDescription(ticketDto.getDescription());
        ticket.setSeverity(ticketDto.getSeverity());
        ticket.setStatus(ticketDto.getStatus());
        ticketDto.setTicketAssignee(ticketDto.getTicketAssignee());
        ticketDto.setTicketWatchers(ticketDto.getTicketWatchers());
        ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Long ticketNumber) {
        ticketRepository.deleteById(ticketNumber);
    }

    @Override
    public void assignWatchers(Long ticketNumber, List<Long> employeeNumbers) {
        Ticket ticket = ticketRepository.findTicketByTicketNumber(ticketNumber);
        ticket.setTicketWatchers(employeeRepository.findByEmployeeNumberIn(employeeNumbers));
        ticketRepository.save(ticket);
    }

}
