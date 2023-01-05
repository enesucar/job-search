package com.topkapi.jobsearch.mapper;

import com.topkapi.jobsearch.dto.CategoryDto;
import com.topkapi.jobsearch.dto.PositionDto;
import com.topkapi.jobsearch.model.Category;
import com.topkapi.jobsearch.model.Position;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PositionMapper {
    PositionDto map(Position position);
    List<PositionDto> map(List<Position> positions);
}
