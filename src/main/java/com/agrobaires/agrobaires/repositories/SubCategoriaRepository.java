package com.agrobaires.agrobaires.repositories;

import com.agrobaires.agrobaires.entities.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Long>, JpaSpecificationExecutor<SubCategoria> {

    @Query("select s from sub_categoria s where w.id_sub_cat = :idSubCat")
    SubCategoria obtenerSubCategoriaPorId(@Param("idSubCat") String idSubCat);

    @Query("select s from sub_categoria s where w.id_cat = :idCat")
    SubCategoria obtenerSubCategoriaPorIdCategoria(@Param("idCat") String idCat);

}
