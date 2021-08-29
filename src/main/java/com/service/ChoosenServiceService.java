package com.service;

import com.entity.ChoosenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.ChoosenServiceRepository;

import java.util.List;

@Service
public class ChoosenServiceService {

    @Autowired
    private final ChoosenServiceRepository choosenServiceRepository;

    public ChoosenServiceService (ChoosenServiceRepository choosenServiceRepository) {
        this.choosenServiceRepository = choosenServiceRepository;
    }

    public int count() {
        return (int) choosenServiceRepository.count();
    }

    public void createChoosenService(ChoosenService choosenService) {
        choosenServiceRepository.save(choosenService);
    }

    public ChoosenService findById(Long id) {
        return choosenServiceRepository.findById(id).orElse(null);
    }

    public List<ChoosenService> findAll() {
        return choosenServiceRepository.findAll();
    }
}

