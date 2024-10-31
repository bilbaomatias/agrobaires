package com.agrobaires.agrobaires.repositories;

import com.agrobaires.agrobaires.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {


    @Query("select u from usuarios u where u.id_usuario = :id_usuario")
    Usuario obtenerUsuarioPorId(@Param("id_usuario") Long idUsuario);

    @Query("select u from usuarios u where u.nombre_usuario = :nombre_usuario")
    Usuario obtenerUsuarioPorNombreUsuario(@Param("nombre_usuario") String nombreUsuario);

    @Query("select u from usuarios u where u.email = :email")
    Usuario obtenerUsuarioPorEmail(@Param("email") String email);

    @Query("select u from usuarios u where u.id_rol = :id_rol")
    List<Usuario> obtenerUsuarioPorRol(@Param("id_rol") String rolUsuario);

}
