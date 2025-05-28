package com.logistica.orm4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logistica.orm4.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
    
    @SuppressWarnings("null")
    List<Proveedor> findAll();

    Optional<Proveedor> findById(int id);
    
    @SuppressWarnings({ "null", "unchecked" })
    Proveedor save(Proveedor proveedor);
    
    Boolean existsById(int idProveedor);
    
    
}
