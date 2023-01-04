package com.topkapi.jobsearch.service;

import com.topkapi.jobsearch.exception.EntityNotFoundException;
import com.topkapi.jobsearch.model.Position;
import com.topkapi.jobsearch.repository.PositionRepository;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    protected Position findById(String id) {
        Position position =  this.positionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Position is not found: " + id));
        return position;
    }
}
