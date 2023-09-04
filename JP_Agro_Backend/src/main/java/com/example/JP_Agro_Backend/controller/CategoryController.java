package com.example.JP_Agro_Backend.controller;

import com.example.JP_Agro_Backend.dto.CategoryDTO;
import com.example.JP_Agro_Backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO addedCategory = categoryService.addCategory(categoryDTO);
        return new ResponseEntity<CategoryDTO>(addedCategory, HttpStatus.CREATED);
    }
}
