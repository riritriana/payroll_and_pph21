package com.project.payroll_and_pph21.controllers;

import com.project.payroll_and_pph21.services.PtkpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PtkpController {

    @Autowired
    private PtkpService ptkpService;

    // Menampilkan halaman form dengan daftar status
    @GetMapping("/ptkp")
    public String showPtkpForm(Model model) {
        // model.addAttribute("statuses", ptkpService.getAllStatuses());
        return "/ptkp/ptkp";  // Gantilah sesuai nama template yang digunakan
    }

    // Menghitung dan menampilkan taxRate berdasarkan status yang dipilih
    // @PostMapping("/ptkp-status")
    // public String calculateTaxRate(@RequestParam String status, Model model) {
    //     Double taxRate = ptkpService.getTaxRateByStatus(status);
    //     model.addAttribute("taxRate", taxRate);
    //     return "/ptkp/ptkp";  // Kembali ke halaman yang sama dengan hasil
    // }
}