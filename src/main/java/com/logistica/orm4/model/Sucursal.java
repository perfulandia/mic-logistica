package com.logistica.orm4.model;

import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sucursal")

public class Sucursal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSucursal;

    @Column(nullable = true)
    private LocalTime horario_apertura;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_politica",referencedColumnName = "idPolitica")
    private Politica politicas_locales;

    //private Usuarios personal; //importar desde gestion usuarios

}
