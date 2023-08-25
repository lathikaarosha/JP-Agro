package com.example.JP_Agro_Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tunnels")
public class Tunnel {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "number_of_plants", nullable = false)
    private Integer number_of_plants;

    @OneToMany(mappedBy = "tunnel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<To_Be_Apply_Agrochemicals> agrochemicalsList = new ArrayList<>();


}
