package com.service;

import com.entity.InsuranceCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.InsuranceCaseRepository;

import java.util.List;

@Service
public class InsuranceCaseService {

    @Autowired
    private final InsuranceCaseRepository insuranceCaseRepository;

    public InsuranceCaseService(InsuranceCaseRepository insuranceCaseRepository) {
        this.insuranceCaseRepository = insuranceCaseRepository;
    }

    public int count() {
        return (int) insuranceCaseRepository.count();
    }

    public void createInsuranceCase(InsuranceCase insuranceCase) {
        insuranceCaseRepository.save(insuranceCase);
    }

    public InsuranceCase findById(Long id) {
        return insuranceCaseRepository.findById(id).orElse(null);
    }

    public List<InsuranceCase> findAll() {
        return insuranceCaseRepository.findAll();
    }
}

