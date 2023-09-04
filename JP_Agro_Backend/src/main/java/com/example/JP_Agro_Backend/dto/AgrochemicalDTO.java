package com.example.JP_Agro_Backend.dto;

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

    private CategoryDTO categoryDTO;

    private Date mfd;

    private Date exp;

    private Double quantity;
}
