package com.logistica.orm4.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.logistica.orm4.model.EnvioStarken;

public interface EnvioStarkenRepository extends JpaRepository<EnvioStarken, Integer>{
    
    @SuppressWarnings("null")
    List<EnvioStarken> findAll();
    
    @SuppressWarnings({ "unchecked", "null" })
    EnvioStarken save(EnvioStarken EnvioStarken);
    
    Boolean existsByToken(int numeroTracking);
    
}
