package com.project.payroll_and_pph21.models;

import java.math.BigDecimal;

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
public class TaxBracket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private BigDecimal minPKP;  // Minimum PKP yang dikenakan tarif pajak ini
    private BigDecimal maxPKP;  // Maksimum PKP yang dikenakan tarif pajak ini
    private BigDecimal taxRate;  // Tarif pajak yang berlaku

}
