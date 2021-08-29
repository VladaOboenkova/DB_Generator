package com.service;

import com.entity.TypeOfFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.TypeOfFoodRepository;

import java.util.List;

@Service
public class TypeOfFoodService {

    @Autowired
    private final TypeOfFoodRepository typeOfFoodRepository;

    public TypeOfFoodService(TypeOfFoodRepository typeOfFoodRepository) {
        this.typeOfFoodRepository = typeOfFoodRepository;
    }

    public int count() {
        return (int) typeOfFoodRepository.count();
    }

    public void createTypeOfFood(TypeOfFood typeOfFood) {
        typeOfFoodRepository.save(typeOfFood);
    }

    public TypeOfFood findById(Long id) {
        return typeOfFoodRepository.findById(id).orElse(null);
    }

    public List<TypeOfFood> findAll() {
        return typeOfFoodRepository.findAll();
    }
}

