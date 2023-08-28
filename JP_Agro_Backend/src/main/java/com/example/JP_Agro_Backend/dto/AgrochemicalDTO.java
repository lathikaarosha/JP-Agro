package com.example.JP_Agro_Backend.dto;

import com.example.JP_Agro_Backend.entity.Agrochemical_categories;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgrochemicalDTO {
    private Long agrochemical_id;

    private String name;

    private String brand_name;

    private String description;

    private Agrochemical_categories category;

    private Date mfd;

    private Date exp;

    private Double quantity;
}
