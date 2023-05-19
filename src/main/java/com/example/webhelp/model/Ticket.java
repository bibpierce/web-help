package com.example.webhelp.model;

import com.example.webhelp.enums.Severity;
import com.example.webhelp.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "ticket_number")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketNumber;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "severity")
    private Severity severity;
    @Column(name = "status")
    private Status status;
    @OneToOne
    private Employee ticketAssignee;

    @OneToMany
    private List<Employee> ticketWatchers;



}
