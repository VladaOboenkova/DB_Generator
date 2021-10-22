package com.service;

import com.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.PositionRepository;

import java.util.List;

@Service
public class PositionService {

    @Autowired
    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public int count() {
        return (int) positionRepository.count();
    }

    public void createPosition(Position position) {
        positionRepository.save(position);
    }

    public Position findById(Long id) {
        return positionRepository.findById(id).orElse(null);
    }

    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    public Position findExistingPosition(String name) {
        return positionRepository.findExistingPosition(name);
    }
}
