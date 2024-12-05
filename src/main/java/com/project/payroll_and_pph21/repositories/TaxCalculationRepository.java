package com.project.payroll_and_pph21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.payroll_and_pph21.models.TaxCalculation;

public interface TaxCalculationRepository extends JpaRepository<TaxCalculation, Long> {
        @Query("SELECT COALESCE(SUM(p.pph21Monthly), 0) FROM TaxCalculation p")
    Long getPph21Monthly();

}
