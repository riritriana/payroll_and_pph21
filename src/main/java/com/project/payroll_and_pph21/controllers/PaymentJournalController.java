package com.project.payroll_and_pph21.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PaymentJournalController {
    @GetMapping("/paymentJournal")
    public String paymentJournal() {
        return "/journal/payment-journal";
    }
    
}
