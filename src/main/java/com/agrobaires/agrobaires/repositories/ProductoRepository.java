package com.agrobaires.agrobaires.repositories;

import com.agrobaires.agrobaires.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {

    @Query("select p from Producto p where p.id_producto = :idProducto")
    Producto obtenerPorId(@Param("idProducto") String idProducto);

    @Query("select p from Producto p where p.id_cat_prod = :idCatProducto")
    List<Producto> obtenerTodoPorCategoriaProducto(@Param("idCatProducto") String idCatProducto);

    @Query("update from Producto set ")
    Producto actualizarProducto(Producto producto);

    @Query("selec")
}
