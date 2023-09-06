package com.example.JP_Agro_Backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AgrochemicalCatalogDTO {
    private Long catalog_id;

    private AgrochemicalDTO agrochemicalDTO;

    private Date date;

    private Double quantity;
}
