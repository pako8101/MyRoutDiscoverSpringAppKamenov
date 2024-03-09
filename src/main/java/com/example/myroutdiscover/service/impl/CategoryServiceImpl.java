package com.example.myroutdiscover.service.impl;

import com.example.myroutdiscover.model.entity.Category;
import com.example.myroutdiscover.model.entity.enums.CategoryNameEnum;
import com.example.myroutdiscover.repository.CategoryRepository;
import com.example.myroutdiscover.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
private final CategoryRepository categoryRepository;
@Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findCategoryByName(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByName(categoryNameEnum)
                .orElse(null);
    }
}
