package com.example.webhelp.repository;

import com.example.webhelp.model.EmployeeDTO;
import com.example.webhelp.model.EmployeeRO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Long> {

    EmployeeDTO findEmployeeById(Long id);

}
