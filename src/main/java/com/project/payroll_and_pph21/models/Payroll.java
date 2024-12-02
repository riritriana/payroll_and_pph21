package com.project.payroll_and_pph21.models;

import java.time.LocalDate;

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
    private Employee employee; // Relasi ke karyawan

    private String payPeriod; // Periode pembayaran
    private Double grossIncome; // penghasilan kotor
    private Double employeePremium; // premi yg dibayar karyawan
    private Double positionCost; // biaya jabatan
    private Double netIncomeMonthly; // penghasilan bersih perbulan
    private Double netIncomeYearly; // penghasilan bersih setahun
    private LocalDate paymentDate; // Tanggal pembayaran


}
