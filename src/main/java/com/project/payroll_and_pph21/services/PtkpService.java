package com.project.payroll_and_pph21.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.payroll_and_pph21.models.Ptkp;
import com.project.payroll_and_pph21.repositories.PtkpRepository;

@Service
public class PtkpService {
    @Autowired
    private PtkpRepository ptkpRepository;

    public List<Ptkp> getAllPtkp(){
        return ptkpRepository.findAll();
    }
}
