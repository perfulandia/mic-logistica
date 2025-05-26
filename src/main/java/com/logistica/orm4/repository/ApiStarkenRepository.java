package com.logistica.orm4.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.logistica.orm4.model.ApiStarken;

public interface ApiStarkenRepository extends JpaRepository<ApiStarken, String>{
    
    @SuppressWarnings("null")
    List<ApiStarken> findAll();
    
    @SuppressWarnings({ "unchecked", "null" })
    ApiStarken save(ApiStarken ApiStarken);
    
    Boolean existsByToken(String apiKey);
    
}
