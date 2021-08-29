package com.service;

import com.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.TourAddServiceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourAddServiceService {

    @Autowired
    private final TourAddServiceRepository tourAddServiceRepository;

    public TourAddServiceService(TourAddServiceRepository tourAddServiceRepository) {
        this.tourAddServiceRepository = tourAddServiceRepository;
    }

    public int count() {
        return (int) tourAddServiceRepository.count();
    }

    public void createTourAddService(TourAddService tourAddService) {
        tourAddServiceRepository.save(tourAddService);
    }

    public TourAddService findById(Long tourAddServiceId) {
        return tourAddServiceRepository.findById(tourAddServiceId).orElse(null);
    }

    public List<TourAddService> findAll() {
        return tourAddServiceRepository.findAll();
    }

    public List<Long> findAddServiceForTour(Long tourId){
        List<TourAddService> tourAddServices = findAll();
        List<TourAddService> availableInTour = new ArrayList<>();
        List<Long> addServiceIds = new ArrayList<>();
        for(TourAddService tas : tourAddServices) {
            if (tas.getId_tour().getId().equals(tourId)){
                availableInTour.add(tas);
            }
        }
        for (TourAddService tas : availableInTour){
            addServiceIds.add(tas.getId_add_service().getId());
        }
        return addServiceIds;
    }
}
