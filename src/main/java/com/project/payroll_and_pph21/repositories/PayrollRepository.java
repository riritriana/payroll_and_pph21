package com.project.payroll_and_pph21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.payroll_and_pph21.models.Payroll;

public interface PayrollRepository extends JpaRepository <Payroll,Long>{
    Payroll findPayrollById(Long id);

        @Query("SELECT COALESCE(SUM(p.netIncomeMonthly), 0) FROM Payroll p")
    Long getNetIncomeMonthly();

    // @Query("SELECT COALESCE(SUM(p.netIncomeYaerly), 0) FROM Payroll p")
    // Long getNetIncomeYearly();


}
