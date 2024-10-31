package com.agrobaires.agrobaires.repositories;

import com.agrobaires.agrobaires.entities.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ImagenRepository extends JpaRepository<Imagen, Long>, JpaSpecificationExecutor<Imagen> {


    @Query("select i from Imagen i where i.id_producto = :idProducto")
    Imagen obtenerImagenPorIdProducto(@Param("id_producto") String idProducto);
}
