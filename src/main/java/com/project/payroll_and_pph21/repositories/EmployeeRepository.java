package com.project.payroll_and_pph21.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.payroll_and_pph21.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    Employee findEmployeeByname(String name);
    Employee findEmployeeById(Long id);
    List<Employee> findByNameContainingIgnoreCase(String name);
}
