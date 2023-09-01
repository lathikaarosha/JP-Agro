package com.example.JP_Agro_Backend.service;

import com.example.JP_Agro_Backend.dto.AgrochemicalDTO;

import java.util.List;

public interface AgrochemicalService {
    public AgrochemicalDTO add_agrochemicals(AgrochemicalDTO agrochemicalDTO);

    public List<AgrochemicalDTO> getAllAgrochemicals();

    public AgrochemicalDTO getAgrochemicalById(Long id);

}
