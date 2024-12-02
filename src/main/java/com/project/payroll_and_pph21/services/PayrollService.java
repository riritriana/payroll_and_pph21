package com.project.payroll_and_pph21.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.payroll_and_pph21.models.Employee;
import com.project.payroll_and_pph21.models.Payroll;
import com.project.payroll_and_pph21.repositories.EmployeeRepository;
import com.project.payroll_and_pph21.repositories.PayrollRepository;


@Service
public class PayrollService {
    @Autowired
    private PayrollRepository payrollRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveNewPayroll(Payroll payroll, Employee employee){
        payroll.setNetIncomeMonthly(payroll.getGrossIncome() - payroll.getPositionCost() - payroll.getEmployeePremium());
        payroll.setNetIncomeYearly(payroll.getNetIncomeMonthly() * 12);
        payroll.setEmployee(employeeRepository.findEmployeeByname(employee.getName()));
        payrollRepository.save(payroll);    
    }

    public void save(Payroll payroll) {
        payrollRepository.save(payroll);
    }

    public List<Payroll> getAPayrolls() {
        return payrollRepository.findAll();
    }

    public void delete(Long id) {
        payrollRepository.deleteById(id);
    }

    public Payroll findById(Long id) {
        return payrollRepository.findById(id).orElse(null);
    }

}
