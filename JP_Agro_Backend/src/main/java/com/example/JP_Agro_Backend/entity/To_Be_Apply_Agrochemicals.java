package com.example.JP_Agro_Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "applying_agrochemicals")
public class To_Be_Apply_Agrochemicals {

    @Id
    @Column(name = "work_id")
    private int workdid;

    @ManyToOne
    @JoinColumn(name = "tunnel_id", referencedColumnName = "id")
    private Tunnel tunnel;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @Column(name = "agrochemical_id", nullable = false)
    private Long agrochemical_id;

    @Column(name = "chemical_usage", nullable = false)
    private float usage;

    //other field to add new chemicals




}
