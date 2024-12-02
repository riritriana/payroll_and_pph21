package com.project.payroll_and_pph21.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.payroll_and_pph21.models.TaxCalculation;
import com.project.payroll_and_pph21.services.PayrollService;
import com.project.payroll_and_pph21.services.PtkpService;


@Controller
public class TaxCalculationController {
    @Autowired
    private PayrollService payrollService;
    @Autowired
    private PtkpService ptkpService;
    @GetMapping("/add-tax-calculation/{id}")
    public String addTaxCalculationPage(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("payroll", payrollService.findById(id));
        model.addAttribute("ptkps", ptkpService.getAllPtkp());
        model.addAttribute("taxCalculation", new TaxCalculation());
        return "/taxCalculation/tax-calculation";
    }
    
}
