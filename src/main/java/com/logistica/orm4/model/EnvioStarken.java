package com.logistica.orm4.model;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "envioStarken")

public class EnvioStarken {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroTracking;

    @Enumerated(EnumType.STRING) //almacenar el nombre del estado
    @Column(nullable = false)
    private EnumEstadoEnvio estado;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private LocalTime hora;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sucursal",referencedColumnName = "idSucursal")
    private Sucursal sucursal;

    @Column(nullable = false)
    private String detalle;
}
