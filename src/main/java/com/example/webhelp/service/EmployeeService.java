package com.example.webhelp.service;

import com.example.webhelp.model.Employee;
import com.example.webhelp.model.EmployeeDto;

import java.util.List;

public interface EmployeeService{

    Employee viewEmployee(Long id);
    void createEmployee(Employee employee);
    List<Employee> listEmployeeRecords();
    void updateEmployee(EmployeeDto employeeDto);
    void deleteEmployee(Long id) throws Exception;
    void assignTicket(Long ticketNumber, Long employeeNumbers);

}
