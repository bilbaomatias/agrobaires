package com.agrobaires.agrobaires.entities;

import com.agrobaires.agrobaires.context.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@SequenceGenerator(name = "SEQ_USER", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_USER")
@Table(name = "USUARIOS", uniqueConstraints = {
        @UniqueConstraint(name = "UK_USER", columnNames = { "email" })
        })
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER")
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "telefono")
    private String telefono;

    private String email;

    @Column(name = "id_domicilio")
    private String domicilio;

    @Column(name = "estado")
    private UserStatus estado;

    @Column(name = "id_rol")
    private RolUsuario rolUsuario;

    @Column(name = "pass")
    private String contraseña;

    @Column(name = "id_persona")
    private Persona idPersona;

    @Column(name = "fecha_alta", updatable = false, nullable = false)
    @CreationTimestamp
    private Date fechaDeRegistro;
}
