package com.agrobaires.agrobaires.repositories;

import com.agrobaires.agrobaires.entities.CategoriaProducto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaProdcutoRepository extends JpaRepository<CategoriaProducto, Long>, JpaSpecificationExecutor<CategoriaProducto> {

    @Query("select c from Categoria_Producto c where c.id_cat_prod = :idProducto")
    CategoriaProducto obtenerCategoriaProductoPorId(@Param("id_cat_prod") String idProducto);

    @Query("select c from Categoria_Producto c where c.descripcion_cat_prod = :descripcion_cat_prod")
    List<CategoriaProducto> obtenerCategoriaProductoPorDescripcion(@Param("descripcion_cat_prod") String descripcion);

}
