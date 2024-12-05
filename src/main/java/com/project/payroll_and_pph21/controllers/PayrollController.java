package com.project.payroll_and_pph21.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        System.out.println(payroll);
        model.addAttribute("payrolls", payroll);
        model.addAttribute("employee", employeeService.getAllEmployees());
        return "payroll/payroll";
    }

    @GetMapping("/add-payroll/{id}")
    public String addPayroll(@PathVariable Long id, Model model) {
        model.addAttribute("payroll", payrollService.newPayroll(id));
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
        return "/payroll/update-payroll";
    }

    @PostMapping("/save-payroll")
    public String savePayroll(Payroll payroll, String name, Model model) {
        payrollService.saveNewPayroll(payroll, name);
        return "redirect:/payroll";
    }

    @PostMapping("/save-update-payroll/{id}")
    public String saveUpdate(@PathVariable(value = "id") Long id, @ModelAttribute("payroll") Payroll payroll, Model model) {
        // Cari payroll yang ingin diperbarui berdasarkan ID
        Payroll update = payrollService.findById(id);
        
        if (update != null) {
            update.setEmployee(payroll.getEmployee());
            update.setPayPeriod(payroll.getPayPeriod());  // Periode pembayaran
            update.setPaymentDate(payroll.getPaymentDate());  // Tanggal pembayaran
    
            update.setGrossIncome(payroll.getGrossIncome());  // Penghasilan kotor
            update.setJhtPremium(payroll.getJhtPremium());  // Premi JHT
            update.setPositionCost(payroll.getPositionCost());  // Biaya jabatan
            update.setNetIncomeMonthly(payroll.getNetIncomeMonthly());  // Penghasilan bersih per bulan
            update.setNetIncomeYearly(payroll.getNetIncomeYearly());  // Penghasilan bersih per tahun
    
            update.setJpkPremium(payroll.getJpkPremium());  // Premi JPK
            update.setJkmPremium(payroll.getJkmPremium());  // Premi JKM
            update.setJkkPremium(payroll.getJkkPremium());  // Premi JKK
    
            payrollService.save(update);
        }
    
        return "redirect:/payroll";
    }
    
}
