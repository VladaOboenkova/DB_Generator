package com.service;

import com.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.HotelRepository;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public int count() {
        return (int) hotelRepository.count();
    }

    public void createHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public Hotel findById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }
}
