package com.agrobaires.agrobaires.repositories;

import com.agrobaires.agrobaires.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {


    @Query("select u from usuarios u where u.id_usuario = :id_usuario")
    User findUserById(@Param("id_usuario") Long userId);

    @Query("select u from usuarios u where u.nombre_usuario = :nombre_usuario")
     User findUserByUsername(@Param("nombre_usuario") String username);

    @Query("select u from usuarios u where u.email = :email")
     User findUserByEmail(@Param("email") String email);

    @Query("select u from usuarios u where u.id_rol = :id_rol")
     List<User> findAllUserByRole(@Param("id_rol") String userRole);

}
