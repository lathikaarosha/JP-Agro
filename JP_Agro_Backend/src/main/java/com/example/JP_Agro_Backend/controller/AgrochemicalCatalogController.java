package com.example.JP_Agro_Backend.controller;

import com.example.JP_Agro_Backend.dto.AgrochemicalCatalogDTO;
import com.example.JP_Agro_Backend.service.AgrochemicalCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class AgrochemicalCatalogController {
    @Autowired
    AgrochemicalCatalogService catalogService;

    @PostMapping("")
    public ResponseEntity<AgrochemicalCatalogDTO> addToCatalog(@RequestBody AgrochemicalCatalogDTO catalogDTO){
        AgrochemicalCatalogDTO addedCatalog = catalogService.addAgrochemicalToCatalog(catalogDTO);
        return new ResponseEntity<>(addedCatalog, HttpStatus.CREATED);
    }
}
