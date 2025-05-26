package com.logistica.orm4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.orm4.model.ApiStarken;
import com.logistica.orm4.repository.ApiStarkenRepository;


@Service
public class ApiStarkenService {

    @Autowired
    private ApiStarkenRepository apiStarkenRepository;

    public List<ApiStarken> findAll(){
        return apiStarkenRepository.findAll();
    }
    
    public ApiStarken save(ApiStarken sesion){
        return apiStarkenRepository.save(sesion);
    }

    public Boolean existsByToken(String apiKey){
        return apiStarkenRepository.existsById(apiKey);
    }
}
