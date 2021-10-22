package com.service;

import com.entity.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.InsuranceRepository;

import java.util.List;

@Service
public class InsuranceService {

    @Autowired
    private final InsuranceRepository insuranceRepository;

    public InsuranceService (InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public int count() {
        return (int) insuranceRepository.count();
    }

    public void createInsurance(Insurance insurance) {
        insuranceRepository.save(insurance);
    }

    public Insurance findById(Long id) {
        return insuranceRepository.findById(id).orElse(null);
    }

    public List<Insurance> findAll() {
        return insuranceRepository.findAll();
    }

    public Insurance findExistingInsurance(String name){
        return insuranceRepository.findExistingInsurance(name);
    }
}
