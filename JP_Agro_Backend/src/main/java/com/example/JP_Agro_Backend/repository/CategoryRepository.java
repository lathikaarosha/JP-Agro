package com.example.JP_Agro_Backend.repository;


import com.example.JP_Agro_Backend.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categories, Long> {


}
