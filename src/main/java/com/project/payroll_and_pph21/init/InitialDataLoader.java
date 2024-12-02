package com.project.payroll_and_pph21.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.project.payroll_and_pph21.models.Ptkp;
import com.project.payroll_and_pph21.repositories.PtkpRepository;

@Component
public class InitialDataLoader implements ApplicationRunner {
    @Autowired
    private PtkpRepository ptkpRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (ptkpRepository.findAll().isEmpty()) {
            Ptkp tk0 = new Ptkp(null, "Tk/0", (double) 54_000_000);
            Ptkp tk1 = new Ptkp(null, "Tk/1", (double) 585_000_000);
            Ptkp tk2 = new Ptkp(null, "Tk/2", (double) 63_000_000);
            Ptkp tk3 = new Ptkp(null, "Tk/3", (double) 67_500_000);
            Ptkp k0 = new Ptkp(null, "K/0", (double) 58_500_000);
            Ptkp k1 = new Ptkp(null, "K/1", (double) 63_000_000);
            Ptkp k2 = new Ptkp(null, "K/2", (double) 67_500_000);
            Ptkp k3 = new Ptkp(null, "K/3", (double) 72_000_000);
            ptkpRepository.saveAll(List.of(tk0, tk1, tk2, tk3, k0, k1, k2, k3));
        }
    }
}
