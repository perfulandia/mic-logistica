package com.logistica.orm4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.orm4.model.Proveedor;
import com.logistica.orm4.repository.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> findAll(){
        return proveedorRepository.findAll();
    }

    public Optional<Proveedor> findById(int id){
        return proveedorRepository.findById(id);
    }
    
    public Proveedor save(Proveedor usuario){
        return proveedorRepository.save(usuario);
    }

    public Boolean existsById(int id){
        return proveedorRepository.existsById(id);
    }

    public void deleteById(int id){
        proveedorRepository.deleteById(id);
    }
}
