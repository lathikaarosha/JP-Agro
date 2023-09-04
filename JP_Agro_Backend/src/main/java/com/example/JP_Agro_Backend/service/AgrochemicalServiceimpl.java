package com.example.JP_Agro_Backend.service;

import com.example.JP_Agro_Backend.Exception.ResourceNotFoundExeption;
import com.example.JP_Agro_Backend.dto.AgrochemicalDTO;
import com.example.JP_Agro_Backend.entity.Agrochemicals;
import com.example.JP_Agro_Backend.entity.Categories;
import com.example.JP_Agro_Backend.repository.AgrochemicalRepository;

import com.example.JP_Agro_Backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgrochemicalServiceimpl implements AgrochemicalService{
    private final AgrochemicalRepository agrochemicalRepository;

    public AgrochemicalServiceimpl(AgrochemicalRepository agrochemicalRepository) {
        this.agrochemicalRepository = agrochemicalRepository;
    }

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public AgrochemicalDTO add_agrochemicals(AgrochemicalDTO agrochemical) {

        Categories categories = categoryRepository.findById(agrochemical.getCategoryDTO().getCategory_id()).orElseThrow(()-> new ResourceNotFoundExeption("Category id not found"));

        //AgrochemicalDTO to Agrochemicals conversion
        Agrochemicals agrochemicals = toEntity(agrochemical);

        agrochemicals.setCategories(categories);

        //save the agrochemical
        Agrochemicals save = agrochemicalRepository.save(agrochemicals);


        //Agrochemicals to AgrochemicalDTO conversion
        AgrochemicalDTO dto = toDTO(save);

        return dto;
    }

    @Override
    public List<AgrochemicalDTO> getAllAgrochemicals() {
        List<Agrochemicals> allAgrochemicals = agrochemicalRepository.findAll();

        //Agrochemicals to AgrochemicalDTO conversion
        List<AgrochemicalDTO> allAgrochemicalDTO = allAgrochemicals.stream().map(agrochemicals -> this.toDTO(agrochemicals)).collect(Collectors.toList());
        return allAgrochemicalDTO;
    }

    @Override
    public AgrochemicalDTO getAgrochemicalById(Long id) {
        Agrochemicals agrochemicalsById = agrochemicalRepository.findById(id).orElseThrow(()->new ResourceNotFoundExeption("Product not found"));

        //Agrochemical to AgrochemicalDTO conversion
        AgrochemicalDTO getAgrochemicalDTOById = toDTO(agrochemicalsById);

        return getAgrochemicalDTOById;
    }

    @Override
    public List<AgrochemicalDTO> getAgochemicalsBycategory(Categories categories) {
        return null;
    }


    public Agrochemicals toEntity(AgrochemicalDTO agrochemicalDTO){
        Agrochemicals agrochemicals = new Agrochemicals();

        agrochemicals.setId(agrochemicalDTO.getAgrochemical_id());
        agrochemicals.setName(agrochemicalDTO.getName());
        agrochemicals.setBrand_name(agrochemicalDTO.getBrand_name());
        agrochemicals.setDescription(agrochemicalDTO.getDescription());
        agrochemicals.setMfd(agrochemicalDTO.getMfd());
        agrochemicals.setExp(agrochemicalDTO.getExp());
        agrochemicals.setQuantity(agrochemicalDTO.getQuantity());

        return  agrochemicals;
    }

    public AgrochemicalDTO toDTO(Agrochemicals agrochemicals){
        AgrochemicalDTO agrochemicalDTO = new AgrochemicalDTO();

        agrochemicalDTO.setAgrochemical_id(agrochemicals.getId());
        agrochemicalDTO.setName(agrochemicals.getName());
        agrochemicalDTO.setDescription(agrochemicalDTO.getDescription());
        agrochemicalDTO.setBrand_name(agrochemicals.getBrand_name());
        agrochemicalDTO.setMfd(agrochemicals.getMfd());
        agrochemicalDTO.setExp(agrochemicals.getExp());
        agrochemicalDTO.setQuantity(agrochemicals.getQuantity());

        return agrochemicalDTO;
    }
}
