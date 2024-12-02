package com.project.payroll_and_pph21.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.project.payroll_and_pph21.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/home")
    public String home( Model model) {
        Long ammountEmployees= employeeRepository.count();
        model.addAttribute("ammountEmployees", ammountEmployees);
        return "/home";
    }

    // @GetMapping("/")
    // public String getMethodName(@RequestParam String param) {
    //     return new String();
    // }
    
}
