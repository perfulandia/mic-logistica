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
import com.logistica.orm4.model.Proveedor;
import com.logistica.orm4.service.ProveedorService;


@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>> getProveedor() { // mapea la tabla desde la db
        List<Proveedor> proveedores = proveedorService.findAll();

        if (!proveedores.isEmpty()) {
            return new ResponseEntity<>(proveedores, HttpStatus.OK); // devuelve la entidad con un status http
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor proveedor) {

        if (proveedor != null && !proveedorService.existsById(proveedor.getIdProveedor())) {

            return new ResponseEntity<>(proveedorService.save(proveedor), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    
}
