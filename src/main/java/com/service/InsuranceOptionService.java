package com.service;

import com.entity.InsuranceOption;
import com.entity.InsuranceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.InsuranceOptionRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InsuranceOptionService {

    @Autowired
    private final InsuranceOptionRepository insuranceOptionRepository;

    public InsuranceOptionService (InsuranceOptionRepository insuranceOptionRepository) {
        this.insuranceOptionRepository = insuranceOptionRepository;
    }

    public int count() {
        return (int) insuranceOptionRepository.count();
    }

    public void createInsuranceOption(InsuranceOption insuranceOption) {
        insuranceOptionRepository.save(insuranceOption);
    }

    public InsuranceOption findById(Long insuranceOptionId) {
        return insuranceOptionRepository.findById(insuranceOptionId).orElse(null);
    }

    public List<InsuranceOption> findAll() {
        return insuranceOptionRepository.findAll();
    }

    public Map<InsuranceType, BigDecimal> findInsuranceTypesAndCostsForInsurance(Long insuranceId){
        List<InsuranceOption> insuranceOptions = findAll();
        List<InsuranceOption> availableInInsurance = new ArrayList<>();
        Map<InsuranceType, BigDecimal> insuranceTypeAndCostForInsurance = new HashMap<>();
        for(InsuranceOption io : insuranceOptions) {
            if (io.getId_insurance().getId().equals(insuranceId)){
                availableInInsurance.add(io);
            }
        }
        for (InsuranceOption io : availableInInsurance){
            insuranceTypeAndCostForInsurance.put(io.getId_insurance_type(), io.getSum_insured());
        }
        return insuranceTypeAndCostForInsurance;
    }
}
