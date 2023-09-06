package com.example.JP_Agro_Backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "agrochemical_catalog")
public class AgrochemicalCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agrochemical_id", referencedColumnName = "id")
    private Agrochemicals agrochemicals;


    @Column(name = "Date", nullable = false)
    private Date date;

    @Column(name = "quantity", nullable = false)
    private double quantity;

}
