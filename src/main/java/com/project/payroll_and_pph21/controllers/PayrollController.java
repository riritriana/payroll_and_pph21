package com.project.payroll_and_pph21.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.payroll_and_pph21.models.Employee;
import com.project.payroll_and_pph21.models.Payroll;
import com.project.payroll_and_pph21.services.EmployeeService;
import com.project.payroll_and_pph21.services.PayrollService;

@Controller
public class PayrollController {
    @Autowired
    private PayrollService payrollService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/payroll")
    public String payroll(Model model) {
        List<Payroll> payroll = payrollService.getAPayrolls();
        model.addAttribute("payroll", payroll);
        model.addAttribute("employee", employeeService.getAllEmployees());
        return "payroll/payroll";
    }

    @GetMapping("/add-payroll/{id}")
    public String addPayroll(@PathVariable Long id, Model model) {
        model.addAttribute("payroll", new Payroll());
        model.addAttribute("employee", employeeService.findById(id));
        return "/payroll/add-payroll";
    }

    @GetMapping("/delete-payroll/{id}")
    public String deletePayroll(@PathVariable(value = "id") Long id, Model model) {
        payrollService.delete(id);
        return "redirect:/payroll";
    }

    @GetMapping("/update-payroll/{id}")
    public String updatePayroll(@PathVariable(value = "id") Long id, Model model) {
        Payroll payroll = payrollService.findById(id);
        model.addAttribute("payroll", payroll);
        model.addAttribute("employee", employeeService.getAllEmployees());
        return "/payroll/payroll";
    }

    @PostMapping("/save-payroll")
    public String savePayroll(Payroll payroll, Employee employee, Model model) {
        payrollService.saveNewPayroll(payroll, employee);
        return "redirect:/payroll";
    }

    @PostMapping("/save-update-payroll/{id}")
    public String saveUpdate(@PathVariable(value = "id") Long id, @ModelAttribute("payroll") Payroll payroll,
            Model model) {
        Payroll update = payrollService.findById(id);
        if (update != null) {
            update.setEmployee(payroll.getEmployee());
            update.setPayPeriod(payroll.getPayPeriod());
            update.setGrossIncome(payroll.getGrossIncome());
            update.setEmployeePremium(payroll.getEmployeePremium());
            update.setPositionCost(payroll.getPositionCost());
            update.setNetIncomeMonthly(payroll.getNetIncomeMonthly());
            update.setNetIncomeYearly(payroll.getNetIncomeYearly());
            update.setPaymentDate(payroll.getPaymentDate());
            payrollService.save(update);
        }
        return "redirect:/payroll";
    }

}
