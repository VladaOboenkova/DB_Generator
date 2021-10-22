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

    public List<TourAddService> findTAS(Tour tour){
        return tourAddServiceRepository.findTAS(tour);
    }

    public List<AddService> findAddServiceForTour(Tour tour){
        List<TourAddService> tas = findTAS(tour);
        List<AddService> addServices = new ArrayList<>();
        for (TourAddService t : tas){
            addServices.add(t.getId_add_service());
        }
        return addServices;
    }

    public TourAddService findExistingTAS(Tour id_tour, AddService id_add_service){
        return tourAddServiceRepository.findExistingTAS(id_tour, id_add_service);
    }

}
