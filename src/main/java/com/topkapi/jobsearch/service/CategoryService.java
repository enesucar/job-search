package com.topkapi.jobsearch.service;

import com.topkapi.jobsearch.exception.EntityNotFoundException;
import com.topkapi.jobsearch.model.Category;
import com.topkapi.jobsearch.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

     protected Category findById(String id) {
        Category category =  this.categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category is not found: " + id));
        return category;
    }
}
