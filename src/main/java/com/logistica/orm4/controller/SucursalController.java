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

import com.logistica.orm4.model.Sucursal;
import com.logistica.orm4.service.SucursalService;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public ResponseEntity<List<Sucursal>> getSucursales() { // mapea la tabla desde la db
        List<Sucursal> sucursales = sucursalService.findAll();

        if (!sucursales.isEmpty()) {
            return new ResponseEntity<>(sucursales, HttpStatus.OK); 
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Sucursal> crearSucursal(@RequestBody Sucursal sucursal) {

        if (sucursal != null && !sucursalService.existsById(sucursal.getIdSucursal())) { //recordar que el token es un String, no un int

            return new ResponseEntity<>(sucursalService.save(sucursal), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
