package com.example.JP_Agro_Backend.repository;

import com.example.JP_Agro_Backend.entity.Agrochemicals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AgrochemicalRepository extends JpaRepository<Agrochemicals, Long> {

}
