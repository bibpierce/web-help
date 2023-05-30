package com.example.webhelp.repository;

import com.example.webhelp.model.Employee;
import com.example.webhelp.model.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeById(Long id);

    Employee findEmployeeByEmployeeNumber(Long employeeNumber);

    List<Employee> findByEmployeeNumberIn(List<Long> employeeNumbers);

}
