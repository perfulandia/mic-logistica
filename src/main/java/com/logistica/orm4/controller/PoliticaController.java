package com.logistica.orm4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logistica.orm4.model.Politica;
import com.logistica.orm4.service.PoliticaService;

@RestController
@RequestMapping("/api/politica")
public class PoliticaController {

    @Autowired
    private PoliticaService politicaService;

    @GetMapping
    public ResponseEntity<List<Politica>> getPolitica() { 
        List<Politica> politicas = politicaService.findAll();

        if (!politicas.isEmpty()) {
            return new ResponseEntity<>(politicas, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Politica> crearPolitica(@RequestBody Politica politicas) {

        if (politicas != null && !politicaService.existsByToken(politicas.getIdPolitica())) {

            return new ResponseEntity<>(politicaService.save(politicas), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
