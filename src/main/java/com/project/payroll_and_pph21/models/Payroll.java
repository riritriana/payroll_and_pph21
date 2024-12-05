package com.project.payroll_and_pph21.models;

import java.time.LocalDate;
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
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee; // Relasi ke employee

    private String payPeriod; // Periode pembayaran
    private LocalDate paymentDate; // Tanggal pembayaran

    @Column(precision = 10, scale=0)
    private BigDecimal grossIncome; // Penghasilan kotor

    @Column(precision = 10, scale=0)
    private BigDecimal jpkPremium; // Premi JPK (6%)

    @Column(precision = 10, scale=0)
    private BigDecimal jkmPremium; // Premi JKM (0.3%)

    @Column(precision = 10, scale=0)
    private BigDecimal jkkPremium; // Premi JKK (1.27%)
    @Column(precision = 10, scale=0)
    private BigDecimal positionCost; // Biaya jabatan (5% dari gross income)
    @Column(precision = 10, scale=0)
    private BigDecimal jhtPremium; // Premi JHT (2% dari basic salary)
    @Column(precision = 10, scale=0)
    private BigDecimal netIncomeMonthly; // Penghasilan bersih per bulan
    @Column(precision = 10, scale=0)
    private BigDecimal netIncomeYearly; // Penghasilan bersih per tahun
}
