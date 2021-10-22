package com.service;

import com.entity.Order;
import com.entity.PersonInfo;
import com.entity.Tourists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.TouristsRepository;

import java.util.List;

@Service
public class TouristsService {

    @Autowired
    private final TouristsRepository touristsRepository;

    public TouristsService(TouristsRepository touristsRepository) {
        this.touristsRepository = touristsRepository;
    }

    public int count() {
        return (int) touristsRepository.count();
    }

    public void createTourists(Tourists tourists) {
        touristsRepository.save(tourists);
    }

    public Tourists findById(Long touristsId) {
        return touristsRepository.findById(touristsId).orElse(null);
    }

    public List<Tourists> findAll() {
        return touristsRepository.findAll();
    }

    public  List<Tourists> findAllForOrder(Long id_order){
        return touristsRepository.touristForOrder(id_order);
    }

    public Tourists findExistingTourists(Order id_order, PersonInfo id_person_info){
        return touristsRepository.findExistingTourists(id_order, id_person_info);
    }
}
