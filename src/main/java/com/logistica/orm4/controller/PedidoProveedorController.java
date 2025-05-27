package com.logistica.orm4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.logistica.orm4.model.PedidoProveedor;
import com.logistica.orm4.service.PedidoProveedorService;

public class PedidoProveedorController {

    @Autowired
    private PedidoProveedorService pedidoProveedorService;

    @GetMapping
    public ResponseEntity<List<PedidoProveedor>> getPedidos() { 
        List<PedidoProveedor> pedidos = pedidoProveedorService.findAll();

        if (!pedidos.isEmpty()) {
            return new ResponseEntity<>(pedidos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<PedidoProveedor> crearPedidos(@RequestBody PedidoProveedor pedidos) {

        if (pedidos != null && !pedidoProveedorService.existsByidPedido(pedidos.getIdPedido())) {

            return new ResponseEntity<>(pedidoProveedorService.save(pedidos), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
