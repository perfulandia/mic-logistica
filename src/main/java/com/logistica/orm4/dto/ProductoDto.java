package com.logistica.orm4.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ProductoDto {
    
    private Long id;
    
    private String nombre;

    private Long precio;

    private int stock;

    private String marca;
}
