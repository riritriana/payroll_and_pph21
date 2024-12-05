package com.project.payroll_and_pph21.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.payroll_and_pph21.models.TaxCalculation;
import com.project.payroll_and_pph21.services.PayrollService;
import com.project.payroll_and_pph21.services.PtkpService;
import com.project.payroll_and_pph21.services.TaxCalculationService;


@Controller
public class TaxCalculationController {
    @Autowired
    private PayrollService payrollService;
    @Autowired
    private PtkpService ptkpService;
    @Autowired
    private TaxCalculationService taxCalculationService;

    @GetMapping("/add-tax-calculation/{id}")
    public String addTaxCalculationPage(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("payroll", payrollService.findById(id));
        model.addAttribute("ptkps", ptkpService.getAllPtkp());
        model.addAttribute("taxCalculation", new TaxCalculation());
        ObjectMapper objectMapper = new ObjectMapper();
        model.addAttribute("ptkpsJson", objectMapper.writeValueAsString(ptkpService.getAllPtkp()));
        return "/taxCalculation/tax-calculation";
    }

    @PostMapping("/save-tax-calculation")
    public String addTaxCalculation(Long id, TaxCalculation taxCalculation, String ptkpId) {
        taxCalculationService.saveTaxCalculation(id, taxCalculation, ptkpId);
        return "redirect:/show-tax-calculation";// ini arahkan
    }

    @GetMapping("/getPph21")
    public String getPph21(Model model) {
        // Mendapatkan total taxableIncome
        // BigDecimal totalTaxableIncome =
        // taxCalculationRepository.getTotalTaxableIncome();
        // model.addAttribute("totalTaxableIncome", totalTaxableIncome);
        return "/journal/paymentJournal";
    }
    @GetMapping("/show-tax-calculation")
    public String getShow(Model model) {
        List<TaxCalculation> taxCalculations= taxCalculationService.geTaxCalculations();
        model.addAttribute("taxCalculation", taxCalculations);
        return "/taxCalculation/show-tax-calculation";
    }
    
    

}
