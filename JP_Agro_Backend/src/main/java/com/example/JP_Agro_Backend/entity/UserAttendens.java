package com.example.JP_Agro_Backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "user_attendens")
public class UserAttendens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendence_id")
    private Long attendence_id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "Date", nullable = false)
    private LocalDate date;

    @Column(name = "attendance_status", nullable = false)
    private Boolean attendence_status;

    @Column(name = "in_time")
    private LocalTime in_time;

    @Column(name = "out_time")
    private LocalTime out_time;

    @Column(name = "approval_status")
    private Boolean approval;

}
