package com.project.payroll_and_pph21.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.payroll_and_pph21.models.Employee;
// import com.project.payroll_and_pph21.repositories.EmployeeRepository;
import com.project.payroll_and_pph21.services.EmployeeService;
// import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // @Autowired
    // private EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public String employee(Model model) {
        List<Employee> employee = employeeService.getAllEmployees();
        model.addAttribute("employee", employee);
        return "/employee/employee";
    }

    @GetMapping("/add-employee")
    public String addEmployee(Model model) {
        // List<Employee> employees = new ArrayList<>();
        model.addAttribute("employee", new Employee());
        return "/employee/add-employee";
    }

        @PostMapping("/save-employee")
    public String saveEmployee(Employee employee, Model model){
        employeeService.save(employee);
        return "redirect:/employee";
    }    

        @GetMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id, Model model) {
        employeeService.delete(id);
        return "redirect:/employee";
    }

    @GetMapping("/update-employee/{id}")
    public String updateEmployee(@PathVariable(value = "id") Long id, Model model) {
    Employee employee = employeeService.findById(id);
    model.addAttribute("employee", employee);
    return "/employee/update-employee";
    }

        @PostMapping("save-update-employee/{id}")
    public String saveUpdate(@PathVariable(value = "id") Long id, @ModelAttribute("employee") Employee employee, Model model){
        Employee update = employeeService.findById(id);
        if (update != null) {
            update.setName(employee.getName());
            update.setGender(employee.getGender());
            update.setPositionName(employee.getPositionName());
            update.setBasicSalary(employee.getBasicSalary());
            update.setAllowances(employee.getAllowances());
            update.setEmployerPremium(employee.getEmployerPremium());
            update.setNpwpStatus(employee.getNpwpStatus());
            employeeService.save(update);
        }
        return "redirect:/employee";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam("search") String name, Model model) {
        List<Employee> employee = employeeService.searchByName(name); 
        model.addAttribute("employee", employee); // Kirim hasil pencarian ke view
        return "/employee/employee"; // Kembali ke halaman yang menampilkan daftar employee
    }    

    @GetMapping("/sort-by-name-asc")
    public String sortByNameAsc(Model model) {
        List<Employee> employee = employeeService.sortByNameAsc();   
        model.addAttribute("employee", employee);
        return "/employee/employee";
    
    }
    


}
