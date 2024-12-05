package com.project.payroll_and_pph21.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.payroll_and_pph21.services.PaymentJournalService;



@Controller
public class PaymentJournalController {

    @Autowired
    private PaymentJournalService paymentJournalService;

    @GetMapping("/paymentJournal")
    public String paymentJournal(Model model) {
        model.addAttribute("bebanGaji", paymentJournalService.getBebanGaji());
        model.addAttribute("utangPph21", paymentJournalService.getUtangPph21());
        model.addAttribute("utangGaji", paymentJournalService.getBebanGaji().subtract(paymentJournalService.getUtangPph21()));
        return "/journal/payment-journal";
    }

    @GetMapping("/pph21")
    public String getPph21(@RequestParam String param) {
        return new String();
    }
    
    
}
