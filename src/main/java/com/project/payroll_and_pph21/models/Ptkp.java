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
public class Ptkp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private Double taxRatePtkp;

    // private Integer Wp;// wajib pajak
    // private Integer dependents;// jumlah tanggungan
    // private BigDecimal ptkpAmmount;

}
