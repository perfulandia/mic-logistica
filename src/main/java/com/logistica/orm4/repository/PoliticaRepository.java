package com.logistica.orm4.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.logistica.orm4.model.Politica;

public interface PoliticaRepository extends JpaRepository<Politica, Integer>{
    
    @SuppressWarnings("null")
    List<Politica> findAll();
    
    @SuppressWarnings({ "unchecked", "null" })
    Politica save(Politica rol);
    
    Boolean existsById(int idPolitica);
    
}
