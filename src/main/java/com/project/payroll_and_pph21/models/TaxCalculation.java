package com.project.payroll_and_pph21.models;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class TaxCalculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee; // Relasi ke karyawan

    @ManyToOne
    @JoinColumn(name = "payroll_id")
    private Payroll payroll;

    @ManyToOne
    @JoinColumn(name = "ptkp_id", referencedColumnName = "id")
    private Ptkp ptkp;

    @Column(precision = 10, scale=0)
    private BigDecimal taxableIncome; //  pkp

    @Column(precision = 10, scale=0)
    private BigDecimal taxBracket; // relasi ke golongan pajak    
    
    @Column(precision = 10, scale=0)
    private BigDecimal pph21Monthly; // PPH21 SEBULAN 


}
