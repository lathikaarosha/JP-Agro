package com.example.JP_Agro_Backend.service;

import com.example.JP_Agro_Backend.dto.AgrochemicalDTO;
import com.example.JP_Agro_Backend.dto.CategoryDTO;
import com.example.JP_Agro_Backend.entity.Agrochemicals;
import com.example.JP_Agro_Backend.entity.Categories;
import com.example.JP_Agro_Backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceimpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {

        Categories agrochemicals = ToEntity(categoryDTO);

        categoryRepository.save(agrochemicals);

        CategoryDTO dto = ToDTO(agrochemicals);

        return dto;
    }

    private Categories ToEntity(CategoryDTO categoryDTO){
        Categories categories = new Categories();

        categories.setId(categoryDTO.getCategory_id());
        categories.setCategory(categoryDTO.getCategory());

        return categories;
    }

    private CategoryDTO ToDTO(Categories categories){
        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setCategory_id(categories.getId());
        categoryDTO.setCategory(categories.getCategory());

        return categoryDTO;
    }
}
