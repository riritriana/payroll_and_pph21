package com.project.payroll_and_pph21.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.payroll_and_pph21.models.Payroll;
import com.project.payroll_and_pph21.models.TaxCalculation;
import com.project.payroll_and_pph21.repositories.PayrollRepository;
import com.project.payroll_and_pph21.repositories.PtkpRepository;
import com.project.payroll_and_pph21.repositories.TaxCalculationRepository;

@Service
public class TaxCalculationService {
    @Autowired
    private TaxCalculationRepository taxCalculationRepository;
    @Autowired
    private PayrollRepository payrollRepository;
    @Autowired
    private PtkpRepository ptkpRepository;

    public void saveTaxCalculation(Long id, TaxCalculation taxCalculation, String ptkp){
        Payroll payroll = payrollRepository.findPayrollById(id);
        TaxCalculation newTaxCalculation = new TaxCalculation();
        newTaxCalculation.setEmployee(payroll.getEmployee());
        newTaxCalculation.setPayroll(payroll);
        newTaxCalculation.setPtkp(ptkpRepository.findPtkpByStatus(ptkp));
        newTaxCalculation.setTaxableIncome(taxCalculation.getTaxableIncome());
        newTaxCalculation.setPph21Monthly(taxCalculation.getPph21Monthly());
        newTaxCalculation.setTaxBracket(taxCalculation.getTaxBracket());
        taxCalculationRepository.save(newTaxCalculation);
    }

    public List<TaxCalculation> geTaxCalculations(){
        return taxCalculationRepository.findAll();
    }
}
