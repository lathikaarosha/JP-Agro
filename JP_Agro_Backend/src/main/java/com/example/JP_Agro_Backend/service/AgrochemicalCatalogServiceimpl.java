package com.example.JP_Agro_Backend.service;

import com.example.JP_Agro_Backend.Exception.ResourceNotFoundExeption;
import com.example.JP_Agro_Backend.dto.AgrochemicalCatalogDTO;
import com.example.JP_Agro_Backend.entity.AgrochemicalCatalog;
import com.example.JP_Agro_Backend.entity.Agrochemicals;
import com.example.JP_Agro_Backend.repository.AgrochemicalCatalogRepository;
import com.example.JP_Agro_Backend.repository.AgrochemicalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgrochemicalCatalogServiceimpl implements AgrochemicalCatalogService {
    @Autowired
    AgrochemicalCatalogRepository catalogRepository;

    @Autowired
    AgrochemicalRepository agrochemicalRepository;

    @Autowired
    AgrochemicalService agrochemicalService;

    @Override
    public AgrochemicalCatalogDTO addAgrochemicalToCatalog(AgrochemicalCatalogDTO catalogDTO) {

        Agrochemicals agrochemicals = agrochemicalRepository.findById(catalogDTO.getAgrochemicalDTO().getAgrochemical_id())
                .orElseThrow(() -> new ResourceNotFoundExeption("Agrochemical not found"));

        AgrochemicalCatalog entity = ToEntity(catalogDTO);
        entity.setAgrochemicals(agrochemicals);
        catalogRepository.save(entity);
        agrochemicalService.renewAgrochemical(catalogDTO);
        return ToDTO(entity);
    }

    private AgrochemicalCatalog ToEntity(AgrochemicalCatalogDTO catalogDTO) {
        AgrochemicalCatalog entity = new AgrochemicalCatalog();

        BeanUtils.copyProperties(catalogDTO, entity);
        entity.setId(catalogDTO.getCatalog_id());

        return entity;
    }

    private AgrochemicalCatalogDTO ToDTO(AgrochemicalCatalog catalog) {
        AgrochemicalCatalogDTO dto = new AgrochemicalCatalogDTO();

        BeanUtils.copyProperties(catalog, dto);
        dto.setCatalog_id(catalog.getId());

        return dto;
    }


}
