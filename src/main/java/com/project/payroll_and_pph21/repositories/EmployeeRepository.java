package com.project.payroll_and_pph21.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.payroll_and_pph21.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    Employee findEmployeeByname(String name);

    List<Employee> findByNameContainingIgnoreCase(String name);
    List<Employee> findAll(Sort sort);
}
