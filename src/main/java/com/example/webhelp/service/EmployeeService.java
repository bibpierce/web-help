package com.example.webhelp.service;

import com.example.webhelp.model.EmployeeDTO;
import com.example.webhelp.model.EmployeeRO;

import java.util.List;

public interface EmployeeService{

    EmployeeDTO viewEmployee(Long id);
    void createEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> listEmployeeRecords();
    void updateEmployee(EmployeeRO employeeRO);
    void deleteEmployee(Long id);
}
