package com.agrobaires.agrobaires.dao;

import com.agrobaires.agrobaires.entities.Producto;
import com.agrobaires.agrobaires.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductoDAO {

    @Autowired
    ProductoRepository productoRepository;

    public Producto saveProducto (Producto producto){
        return productoRepository.save(producto);
    }

    public Producto updProducto (Producto producto){
        return productoRepository.actualizarProducto(producto);
    }

    public Producto getProductoPorId(Long productId) {
        return productoRepository.obtenerPorId(productId.toString());
    }
}
