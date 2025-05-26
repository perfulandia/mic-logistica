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
@Table(name = "proveedor")

public class Proveedor {
    @Id // asigna primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;
    
    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 150, nullable = false)
    private String descripción;

}
