package com.agrobaires.agrobaires.repositories;

import com.agrobaires.agrobaires.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long>, JpaSpecificationExecutor<Persona> {

    @Query("select p from Persona p where p.cuit = :cuit")
    Persona obtenerPorCuit(@Param("cuit") String cuit);

    @Query("select p from Persona p where p.apellido = :apellido")
     List<Persona> obtenerPorApellido(@Param("apellido") String apellido);

    @Query("select p from Persona p where p.insertion_date between :startDate and :endDate")
     List<Persona> obtenerPorFechasRegistro(@Param("startDate") Date fechaDesde, @Param("endDate") Date fechaHasta);

    @Transactional
    @Modifying
    @Query("delete from Persona p where p.cuit = :cuit")
    int borrarPersonPorCuit(@Param("cuit") String cuit);
}
