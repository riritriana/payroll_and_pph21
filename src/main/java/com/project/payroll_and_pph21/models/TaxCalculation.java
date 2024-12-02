package com.project.payroll_and_pph21.models;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

    @OneToOne
    @JoinColumn(name = "payroll_id")
    private Payroll payroll;

    @OneToOne
    @JoinColumn(name = "ptkp_id", referencedColumnName = "id")
    private Ptkp ptkp;

    @OneToOne
    @JoinColumn(name ="taxBracket_id", referencedColumnName = "id")
    private TaxBracket taxBracket; // relasi ke golongan pajak
    

    private BigDecimal taxableIncome; //  pkp
    private BigDecimal pph21Yearly; // PPH21 TERUTANG SETAHUN
    private BigDecimal pph21Monthly; // PPH21 SEBULAN 


}
