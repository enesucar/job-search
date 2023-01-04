package com.topkapi.jobsearch.service;

import com.topkapi.jobsearch.dto.ApplicationDto;
import com.topkapi.jobsearch.dto.CategoryDto;
import com.topkapi.jobsearch.exception.EntityNotFoundException;
import com.topkapi.jobsearch.mapper.CategoryMapper;
import com.topkapi.jobsearch.model.Application;
import com.topkapi.jobsearch.model.Category;
import com.topkapi.jobsearch.repository.CategoryRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository,
                           CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryDto> getList() {
        List<Category> categories = this.categoryRepository.findAll();
        return categoryMapper.map(categories);
    }

    public CategoryDto getById(String id) {
        Category category = findById(id);
        return categoryMapper.map(category);
    }

    protected Category findById(String id) {
        Category category =  this.categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category is not found: " + id));
        return category;
    }
}
