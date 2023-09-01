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
@Entity
@Table(name = "works")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id")
    private int workdid;

    @ManyToOne
    @JoinColumn(name = "tunnel_id", referencedColumnName = "id")
    private Tunnel tunnel;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "agrochemical_id", referencedColumnName = "id")
    private Agrochemicals agrochemicals;

    @Column(name = "chemical_usage", nullable = false)
    private float usage;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "status", nullable = false)
    private Boolean status;


}
