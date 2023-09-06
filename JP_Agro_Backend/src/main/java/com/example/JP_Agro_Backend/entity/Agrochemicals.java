package com.example.JP_Agro_Backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "agrochemicals")
public class Agrochemicals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "chemical_name", nullable = false)
    private String name;

    @Column(name = "brand", nullable = false)
    private String brand_name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Categories categories;

    @Column(name = "manufacture_date", nullable = false)
    private Date mfd;

    @Column(name = "expire_date", nullable = false)
    private Date exp;

    @Column(name = "quantity", nullable = false)
    // in KG s
    private double quantity;

    @OneToMany(mappedBy = "agrochemicals", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Work> workList = new ArrayList<>();

    @OneToMany(mappedBy = "agrochemicals", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AgrochemicalCatalog> catelogs = new ArrayList<>();
}
