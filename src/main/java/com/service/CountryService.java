package com.service;

import com.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.CountryRepository;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public int count() {
        return (int) countryRepository.count();
    }

    public void createCountry(Country country) {
        countryRepository.save(country);
    }

    public Country findById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country findExistingCountry(String name) {
        return countryRepository.findExistingCountry(name);
    }
}