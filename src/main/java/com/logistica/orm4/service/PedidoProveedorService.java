package com.logistica.orm4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.orm4.model.PedidoProveedor;
import com.logistica.orm4.repository.PedidoProveedorRepository;

@Service
public class PedidoProveedorService {

    @Autowired
    private PedidoProveedorRepository pedidoProveedorRepository;

    public List<PedidoProveedor> findAll(){
        return pedidoProveedorRepository.findAll();
    }
    
    public PedidoProveedor save(PedidoProveedor rol){
        return pedidoProveedorRepository.save(rol);
    }

    public Boolean existsById(int idPedido){
        return pedidoProveedorRepository.existsByToken(idPedido);
    }
}
