package com.service;

import com.entity.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.TourRepository;

import java.util.List;

@Service
public class TourService {

    @Autowired
    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public int count() {
        return (int) tourRepository.count();
    }

    public void createTour(Tour tour) {
        tourRepository.save(tour);
    }

    public Tour findById(Long id) {
        return tourRepository.findById(id).orElse(null);
    }

    public List<Tour> findAll() {
        return tourRepository.findAll();
    }
}
