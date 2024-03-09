package com.example.myroutdiscover.service;


import com.example.myroutdiscover.model.entity.Category;
import com.example.myroutdiscover.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    Category findCategoryByName(CategoryNameEnum categoryNameEnum);
}
