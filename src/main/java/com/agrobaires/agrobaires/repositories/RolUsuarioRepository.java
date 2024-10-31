package com.agrobaires.agrobaires.repositories;

import com.agrobaires.agrobaires.entities.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Long>, JpaSpecificationExecutor<RolUsuario> {

    @Query("select r from rol_usuarios r where r.id_rol = :idRol")
    RolUsuario obtenerRolPorId(@Param("idRol") String idRol);

    @Query("select r from rol_usuarios r where r.descripcion_rol = :descripcionRol")
    RolUsuario obtenerRolPorDescripcion(@Param("descripcionRol") String descripcionRol);
}
