package com.logistica.orm4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.orm4.model.EnvioStarken;
import com.logistica.orm4.repository.EnvioStarkenRepository;


@Service
public class EnvioStarkenService {

    @Autowired
    private EnvioStarkenRepository envioStarkenRepository;

    public List<EnvioStarken> findAll(){
        return envioStarkenRepository.findAll();
    }
    
    public EnvioStarken save(EnvioStarken sesion){
        return envioStarkenRepository.save(sesion);
    }

    public Boolean existsByToken(int numero_tracking){
        return envioStarkenRepository.existsById(numero_tracking);
    }
}
