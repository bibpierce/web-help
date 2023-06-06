package com.example.webhelp.service;

import com.example.webhelp.enums.Department;
import com.example.webhelp.enums.Status;
import com.example.webhelp.model.Employee;
import com.example.webhelp.model.EmployeeDto;
import com.example.webhelp.model.Ticket;
import com.example.webhelp.repository.EmployeeRepository;
import com.example.webhelp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    TicketRepository ticketRepository;


    @Override
    public Employee viewEmployee(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public void createEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> listEmployeeRecords(){
        return employeeRepository.findAll();
    }



    @Override
    public void updateEmployee(EmployeeDto employeeDto){
        Employee employee = employeeRepository.findEmployeeById(employeeDto.getId());
        employee.setEmployeeNumber(employeeDto.getEmployeeNumber());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setMiddleName(employeeDto.getMiddleName());
        employee.setLastName(employeeDto.getLastName());
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) throws Exception {
        Employee employee = employeeRepository.findEmployeeById(id);
        Ticket ticket = ticketRepository.findTicketByTicketAssignee_EmployeeNumber(employee.getEmployeeNumber());
        if(ticket == null){
            employeeRepository.deleteById(id);
        }else {
            throw new Exception("Cannot delete with existing ticket");
        }
    }

    @Override
    public void assignTicket(Long ticketNumber, Long employeeNumber) {
        Ticket ticket = ticketRepository.findTicketByTicketNumber(ticketNumber);
        ticket.setStatus(Status.ASSIGNED);
        ticket.setTicketAssignee(employeeRepository.findEmployeeByEmployeeNumber(employeeNumber));
        ticketRepository.save(ticket);
    }





}
