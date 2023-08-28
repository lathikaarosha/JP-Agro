package com.example.JP_Agro_Backend.service;

import com.example.JP_Agro_Backend.dto.AgrochemicalDTO;
import com.example.JP_Agro_Backend.entity.Agrochemicals;
import com.example.JP_Agro_Backend.repository.AgrochemicalRepository;
import org.springframework.stereotype.Service;

@Service
public class AgrochemicalServiceimpl implements AgrochemicalService{
    private final AgrochemicalRepository agrochemicalRepository;

    public AgrochemicalServiceimpl(AgrochemicalRepository agrochemicalRepository) {
        this.agrochemicalRepository = agrochemicalRepository;
    }

    @Override
    public AgrochemicalDTO add_agrochemicals(AgrochemicalDTO agrochemical) {

        //AgrochemicalDTO to Agrochemicals conversion
        Agrochemicals agrochemicals = toEntity(agrochemical);

        //save the agrochemical
        Agrochemicals save = agrochemicalRepository.save(agrochemicals);

        //Agrochemicals to AgrochemicalDTO conversion


        return null;
    }

    public Agrochemicals toEntity(AgrochemicalDTO agrochemicalDTO){
        Agrochemicals agrochemicals = new Agrochemicals();

        agrochemicals.setId(agrochemicalDTO.getAgrochemical_id());
        agrochemicals.setCategory(agrochemicalDTO.getCategory());
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

        return agrochemicalDTO;
    }
}
