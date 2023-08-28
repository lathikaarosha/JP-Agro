package com.example.JP_Agro_Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "nic_number", nullable = false, unique = true)
    private String nic_number;

    @Column(name = "date_of_birth", nullable = false)
    private Date birth_date;

    @Formula("date_part('year',AGE(current_date,date_of_birth))")
    @Transient
    private Integer age;

    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "telephone_number", nullable = false)
    private String telephone_num;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Work> workList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAttendens> userAttendens = new ArrayList<>();


}
