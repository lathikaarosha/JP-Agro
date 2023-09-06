package com.example.JP_Agro_Backend.service;

import com.example.JP_Agro_Backend.dto.AgrochemicalCatalogDTO;
import com.example.JP_Agro_Backend.dto.AgrochemicalDTO;
import com.example.JP_Agro_Backend.entity.Categories;

import java.util.List;

public interface AgrochemicalService {
    public AgrochemicalDTO add_agrochemicals(AgrochemicalDTO agrochemicalDTO);

    public List<AgrochemicalDTO> getAllAgrochemicals();

    public AgrochemicalDTO getAgrochemicalById(Long id);

    public List<AgrochemicalDTO> getAgochemicalsBycategory(Categories categories);

    public void renewAgrochemical(AgrochemicalCatalogDTO catalogDTO);

}
