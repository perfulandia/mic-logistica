package com.logistica.orm4.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.logistica.orm4.model.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer>{
    
    @SuppressWarnings("null")
    List<Sucursal> findAll();
    
    @SuppressWarnings({ "null", "unchecked" })
    Sucursal save(Sucursal sucursal);
    
    Boolean existsById(int idSucursal);
    
}
