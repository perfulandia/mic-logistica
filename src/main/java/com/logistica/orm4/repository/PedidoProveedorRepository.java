package com.logistica.orm4.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.logistica.orm4.model.PedidoProveedor;

public interface PedidoProveedorRepository extends JpaRepository<PedidoProveedor, Integer>{
    
    @SuppressWarnings("null")
    List<PedidoProveedor> findAll();
    
    @SuppressWarnings({ "unchecked", "null" })
    PedidoProveedor save(PedidoProveedor sesion);
    
    Boolean existsByidPedido(int idPedido);
    
}
