package com.logistica.orm4.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "politica")

public class Politica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPolitica;
    
    @Column(length = 50, nullable = false)
    private String nombrePolitica;
    
    @Column(length = 100, nullable = true)
    private String detalle;
}
