package com.example.webhelp.controller;


import com.example.webhelp.model.EmployeeDTO;
import com.example.webhelp.model.EmployeeRO;
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
    public ResponseEntity<EmployeeDTO> viewEmployee(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.viewEmployee(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeDTO>> listEmployeeRecords(){
        return new ResponseEntity<>(employeeService.listEmployeeRecords(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.createEmployee(employeeDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateEmployee(@RequestBody EmployeeRO employeeRO){
        employeeService.updateEmployee(employeeRO);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
