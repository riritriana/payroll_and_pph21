package com.project.payroll_and_pph21.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.payroll_and_pph21.models.Ptkp;

public interface PtkpRepository extends JpaRepository<Ptkp,Long> {
    Ptkp findPtkpByStatus(String status);
}
