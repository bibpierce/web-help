package com.example.webhelp.repository;

import com.example.webhelp.model.Employee;
import com.example.webhelp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket findTicketByTicketNumber(Long ticketNumber);

    Ticket findTicketByTicketAssignee_EmployeeNumber(Long ticketNumber);
}
