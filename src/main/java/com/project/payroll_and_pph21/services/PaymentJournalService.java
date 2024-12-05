package com.project.payroll_and_pph21.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.payroll_and_pph21.models.Payroll;
import com.project.payroll_and_pph21.models.TaxCalculation;

@Service
public class PaymentJournalService {
    
    @Autowired
    private PayrollService payrollService;
    @Autowired
    private TaxCalculationService taxCalculationService;

    public BigDecimal getBebanGaji(){
        List<Payroll> payrolls = payrollService.getAPayrolls();
        BigDecimal bebanGaji = new BigDecimal(0).setScale(0);
        for (Payroll payroll : payrolls) {
            bebanGaji = bebanGaji.add(payroll.getNetIncomeMonthly()).setScale(0);
        }
        return bebanGaji;
    }
    
    public BigDecimal getUtangPph21(){
        List<TaxCalculation> taxCalculations = taxCalculationService.geTaxCalculations();
        BigDecimal utangPpph21 = new BigDecimal(0).setScale(0);
        for (TaxCalculation taxCalculation : taxCalculations) {
           utangPpph21 = utangPpph21.add(taxCalculation.getPph21Monthly()).setScale(0);
        }
        return utangPpph21;
    }
}
