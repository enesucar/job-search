package com.topkapi.jobsearch.controller;

import com.topkapi.jobsearch.dto.CategoryDto;
import com.topkapi.jobsearch.dto.PositionDto;
import com.topkapi.jobsearch.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getList() {
        List<CategoryDto> categoryDtos = this.categoryService.getList();
        return ResponseEntity.ok(categoryDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable("id") String id) {
        CategoryDto categoryDto = this.categoryService.getById(id);
        return ResponseEntity.ok(categoryDto);
    }
}
