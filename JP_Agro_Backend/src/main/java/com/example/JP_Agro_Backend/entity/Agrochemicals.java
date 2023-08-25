package com.example.JP_Agro_Backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agrochemicals")
public class Agrochemicals {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "chemical_name", nullable = false)
    private String name;

    @Column(name = "brand", nullable = false)
    private String brand_name;

    @Column(name = "description")
    private String description;

    @Column(name = "category", nullable = false)
    private Agrochemical_categories category;

    @Column(name = "manufacture_date", nullable = false)
    private Date mfd;

    @Column(name = "expire_date", nullable = false)
    private Date exp;

    @Column(name = "quantity", nullable = false)
    // in KG s
    private double quantity;


}
