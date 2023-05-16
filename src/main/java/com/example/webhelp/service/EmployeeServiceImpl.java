package com.example.webhelp.service;

import com.example.webhelp.model.EmployeeDTO;
import com.example.webhelp.model.EmployeeRO;
import com.example.webhelp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public EmployeeDTO viewEmployee(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public void createEmployee(EmployeeDTO employeeDTO){
        employeeRepository.save(employeeDTO);
    }

    @Override
    public List<EmployeeDTO> listEmployeeRecords(){
        return employeeRepository.findAll();
    }

    @Override
    public void updateEmployee(EmployeeRO employeeRO){
        EmployeeDTO employeeDTO = employeeRepository.findEmployeeById(employeeRO.getId());
        employeeDTO.setEmployeeNumber(employeeRO.getEmployeeNumber());
        employeeDTO.setFirstName(employeeRO.getFirstName());
        employeeDTO.setMiddleName(employeeRO.getMiddleName());
        employeeDTO.setLastName(employeeRO.getLastName());
        employeeRepository.save(employeeDTO);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


}
