package com.project.payroll_and_pph21.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String name; // nama karyawan
    private String gender; // jenis kelamin
    
    private String positionName;// nama jabatan
    private Double basicSalary;
    private Double allowances;  // tunjangan
    private Double employerPremium; // premi yang dibayarkan perusahaan
    private String npwpStatus; // status

}
