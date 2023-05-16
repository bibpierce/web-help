package com.example.webhelp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ticket")
public class TicketDTO {

    @Id
    private Long ticketNumber;
    private String title;
    private String description;

}
