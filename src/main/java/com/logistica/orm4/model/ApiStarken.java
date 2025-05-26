package com.logistica.orm4.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "apiStarken")
public class ApiStarken {

    @Id
    @Column(nullable = false)
    private String apiKey;
    
    @Column(nullable = false)
    private String apiUrl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "numero_tracking",referencedColumnName = "numeroTracking")
    private EnvioStarken numero_tracking;
}
