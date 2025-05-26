package com.logistica.orm4.model;

import jakarta.persistence.CascadeType;
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
@Table(name = "pedidoProveedor")

public class PedidoProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_proveedor",referencedColumnName = "idProveedor")
    private Proveedor proveedor;

    //private List<Producto> detalle; //pendiente importar desde el otro microservicio
}

