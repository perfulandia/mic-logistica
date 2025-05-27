package com.logistica.orm4.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.logistica.orm4.dto.ProductoDto;
import com.logistica.orm4.model.PedidoProveedor;
import com.logistica.orm4.model.ProductoCantidad;
import com.logistica.orm4.repository.PedidoProveedorRepository;

@Service
public class PedidoProveedorService {

    @Autowired
    private PedidoProveedorRepository pedidoProveedorRepository;

    @Autowired
    private RestTemplate restTemplate;
    private final String API_URL = "http://localhost:9000/api/v1/inventario";

    public List<PedidoProveedor> findAll(){
        return pedidoProveedorRepository.findAll();
    }
    
    public PedidoProveedor save(PedidoProveedor rol){
        return pedidoProveedorRepository.save(rol);
    }

    public Boolean existsByidPedido(int idPedido){
        return pedidoProveedorRepository.existsByidPedido(idPedido);
    }

    public List<ProductoDto> getProductosPedido(List<Long> ids) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(API_URL + "/by-id/").queryParam("ids", ids);

        ResponseEntity<List<ProductoDto>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ProductoDto>>() {
                });

        return response.getBody();
    }

    public List<List<String>> getNombreProducto(PedidoProveedor pedido) {
        PedidoProveedor nuevoPedido = pedido;

        List<Long> ids = new ArrayList<>();
        List<Long> cantidad = new ArrayList<>();

        for (ProductoCantidad prod : pedido.getProductos()) { // separamos el id de cada producto para buscarlo de la
                                                               // API inventario
            ids.add(prod.getIdProducto());
            cantidad.add(prod.getCantidad());
        }

        List<ProductoDto> productosApi = this.getProductosPedido(ids); // lista de productos del inv
        
        List<List<String>> nombre = new ArrayList<>();

        for (ProductoDto prod : productosApi) { // sumar el valor de cada producto al subtotal
            int i = 0;
            List<String> productos = new ArrayList<>();
            productos.add(prod.getNombre());
            productos.add(String.valueOf(cantidad.get(i)));
            
            nombre.add(productos);

            i++;
        }
        return nombre;
    }
}
