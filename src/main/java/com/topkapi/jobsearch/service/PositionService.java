package com.topkapi.jobsearch.service;

import com.topkapi.jobsearch.dto.PositionDto;
import com.topkapi.jobsearch.exception.EntityNotFoundException;
import com.topkapi.jobsearch.mapper.PositionMapper;
import com.topkapi.jobsearch.model.Position;
import com.topkapi.jobsearch.repository.PositionRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    private final PositionRepository positionRepository;
    private final PositionMapper positionMapper;

    public PositionService(PositionRepository positionRepository,
                           PositionMapper positionMapper) {
        this.positionRepository = positionRepository;
        this.positionMapper = positionMapper;
    }

    public List<PositionDto> getList() {
        List<Position> positions = this.positionRepository.findAll();
        return positionMapper.map(positions);
    }

    public PositionDto getById(String id) {
        Position position = findById(id);
        return positionMapper.map(position);
    }

    protected Position findById(String id) {
        Position position =  this.positionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Position is not found: " + id));
        return position;
    }
}
