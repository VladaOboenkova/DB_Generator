package com.service;

import com.entity.PersonInfo;
import com.entity.TourStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.TourStaffRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourStaffService {

    @Autowired
    private final TourStaffRepository tourStaffRepository;

    public TourStaffService(TourStaffRepository tourStaffRepository) {
        this.tourStaffRepository = tourStaffRepository;
    }

    public int count() {
        return (int) tourStaffRepository.count();
    }

    public void createTourStaff(TourStaff tourStaff) {
        tourStaffRepository.save(tourStaff);
    }

    public TourStaff findById(Long id) {
        return tourStaffRepository.findById(id).orElse(null);
    }

    public List<TourStaff> findAll() {
        return tourStaffRepository.findAll();
    }

//    public List<TourStaff> findAllManagers(){
//        List<TourStaff> tourStaff = findAll();
//        List<TourStaff> managers = new ArrayList<>();
//        for (TourStaff ts : tourStaff) {
//            if (ts.getId_position().getPosition_name().equals("Менеджер") ||
//                    ts.getId_position().getPosition_name().equals("Старший менеджер")){
//                managers.add(ts);
//            }
//        }
//        return managers;
//    }

    public List<TourStaff> findAllManagers(){
        return tourStaffRepository.findManagers();
    }

    public TourStaff findExistingTS(PersonInfo personInfo){
        return tourStaffRepository.findExistingTS(personInfo);
    }
}

