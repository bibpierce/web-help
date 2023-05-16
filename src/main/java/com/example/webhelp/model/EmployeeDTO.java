package com.example.webhelp.model;

import com.example.webhelp.enums.Department;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class EmployeeDTO {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "employee_number")
    private Integer employeeNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "department")
    private Department department;
}
