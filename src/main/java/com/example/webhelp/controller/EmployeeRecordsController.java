package com.example.webhelp.controller;


import com.example.webhelp.model.Employee;
import com.example.webhelp.model.EmployeeDto;
import com.example.webhelp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeRecordsController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/view/{id}")
    public ResponseEntity<Employee> viewEmployee(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.viewEmployee(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> listEmployeeRecords(){
        return new ResponseEntity<>(employeeService.listEmployeeRecords(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateEmployee(@RequestBody EmployeeDto employeeDto){
        employeeService.updateEmployee(employeeDto);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id) throws Exception {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/assign/{ticketNumber}")
    public ResponseEntity assignEmployee(@PathVariable Long ticketNumber, @RequestParam Long employeeNumber){
        employeeService.assignTicket(ticketNumber, employeeNumber);
        return new ResponseEntity<>(employeeNumber,HttpStatus.OK);
    }


}
