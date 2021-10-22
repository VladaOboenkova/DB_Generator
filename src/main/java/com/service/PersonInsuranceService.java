package com.service;

import com.entity.PersonInsurance;
import com.entity.Tourists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.PersonInsuranceRepository;

import java.util.List;

@Service
public class PersonInsuranceService {

    @Autowired
    private final PersonInsuranceRepository personInsuranceRepository;

    public PersonInsuranceService(PersonInsuranceRepository personInsuranceRepository) {
        this.personInsuranceRepository = personInsuranceRepository;
    }

    public int count() {
        return (int) personInsuranceRepository.count();
    }

    public void createPersonInsurance(PersonInsurance personInsurance) {
        personInsuranceRepository.save(personInsurance);
    }

    public PersonInsurance findById(Long id) {
        return personInsuranceRepository.findById(id).orElse(null);
    }

    public List<PersonInsurance> findAll() {
        return personInsuranceRepository.findAll();
    }

    public PersonInsurance findPI(Tourists tourists) {
        return personInsuranceRepository.findPI(tourists);
    }

    public PersonInsurance findPI_PN(String policy_num){
        return personInsuranceRepository.findPI_PN(policy_num);
    }
}
