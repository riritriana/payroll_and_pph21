package com.project.payroll_and_pph21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.payroll_and_pph21.models.TaxBracket;

public interface TaxBracketRepository extends JpaRepository<TaxBracket,Long> {
    
}
