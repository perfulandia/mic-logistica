package com.logistica.orm4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.orm4.model.Sucursal;
import com.logistica.orm4.repository.SucursalRepository;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public List<Sucursal> findAll(){
        return sucursalRepository.findAll();
    }
    
    public Sucursal save(Sucursal permiso){
        return sucursalRepository.save(permiso);
    }

    public Boolean existsById(int idSucursal){
        return sucursalRepository.existsById(idSucursal);
    }
}
