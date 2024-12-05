package com.project.payroll_and_pph21.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.payroll_and_pph21.models.Employee;
import com.project.payroll_and_pph21.repositories.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void save (Employee employee) throws Exception{
        List<Employee> employees = getAllEmployees();
        Boolean same = false;
        for (Employee employee2 : employees) {
            if (employee2.getName().startsWith(employee.getName())) {
                same = true;
                break;
            }
        }
        if (same) {
            throw new Exception("Karyawan Sudah Ada, mohon input nama yang beda");
        }
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

}
