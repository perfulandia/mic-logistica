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

import com.logistica.orm4.model.EnvioStarken;
import com.logistica.orm4.service.EnvioStarkenService;

@RestController
@RequestMapping("/api/envio")
public class EnvioStarkenController {

    @Autowired
    private EnvioStarkenService envioStarkenService;

    @GetMapping
    public ResponseEntity<List<EnvioStarken>> getEnvios() { 
        List<EnvioStarken> envios = envioStarkenService.findAll();

        if (!envios.isEmpty()) {
            return new ResponseEntity<>(envios, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<EnvioStarken> crearEnvios(@RequestBody EnvioStarken envios) {

        if (envios != null && !envioStarkenService.existsBynumeroTracking(envios.getNumeroTracking())) {

            return new ResponseEntity<>(envioStarkenService.save(envios), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
