package com.logistica.orm4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.orm4.model.Politica;
import com.logistica.orm4.repository.PoliticaRepository;

@Service
public class PoliticaService {

    @Autowired
    private PoliticaRepository politicaRepository;

    public List<Politica> findAll(){
        return politicaRepository.findAll();
    }
    
    public Politica save(Politica sesion){
        return politicaRepository.save(sesion);
    }

    public Boolean existsByToken(int idPolitica){
        return politicaRepository.existsById(idPolitica);
    }
}
