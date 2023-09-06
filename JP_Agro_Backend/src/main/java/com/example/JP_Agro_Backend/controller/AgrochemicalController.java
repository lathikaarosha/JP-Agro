package com.example.JP_Agro_Backend.controller;

import com.example.JP_Agro_Backend.dto.AgrochemicalDTO;
import com.example.JP_Agro_Backend.service.AgrochemicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agrochemical")
public class AgrochemicalController {

    @Autowired
    private AgrochemicalService agrochemicalService;

    @PostMapping("")
    public ResponseEntity<AgrochemicalDTO> addAgrochemicals(@RequestBody AgrochemicalDTO agrochemical){
        AgrochemicalDTO addedAgrochemical = agrochemicalService.add_agrochemicals(agrochemical);
        return new ResponseEntity<AgrochemicalDTO>(addedAgrochemical, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<AgrochemicalDTO>> viewAllAgrochemicals(){
        List<AgrochemicalDTO> allAgrochemicals = agrochemicalService.getAllAgrochemicals();
        return new ResponseEntity<List<AgrochemicalDTO>>(allAgrochemicals, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgrochemicalDTO> getAgrochemicalById(@PathVariable(name = "id") Long id){
        AgrochemicalDTO agrochemicaById = agrochemicalService.getAgrochemicalById(id);
        return new ResponseEntity<AgrochemicalDTO>(agrochemicaById, HttpStatus.OK);
    }








}
