package com.project.payroll_and_pph21.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.payroll_and_pph21.models.Employee;
import com.project.payroll_and_pph21.models.Payroll;
import com.project.payroll_and_pph21.repositories.EmployeeRepository;
import com.project.payroll_and_pph21.repositories.PayrollRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PayrollRepository payrollRepository;

    public void save (Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public void delete (Long id){
        employeeRepository.deleteById(id);
    }
    public Employee findById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> searchByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }
  
    public List<Employee> sortByNameAsc() {
        // Menggunakan method findAll() dari JpaRepository yang sudah diurutkan berdasarkan nama
        return employeeRepository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    public Payroll newPayroll(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        Payroll payroll = new Payroll();
        payroll.setEmployee(employee);
        payroll.setGrossIncome(employee.getBasicSalary() + employee.getAllowances() + employee.getEmployerPremium());
        payroll.setPositionCost(payroll.getGrossIncome()*0.05);
        payrollRepository.save(payroll);
        return payroll;
    }

}
