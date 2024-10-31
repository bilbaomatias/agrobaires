package com.agrobaires.agrobaires.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@SequenceGenerator(name = "SEQ_ROLE", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_ROLE")
@Table(name = "ROL_USUARIOS", uniqueConstraints = {
        @UniqueConstraint(name = "SEQ_ROLE", columnNames = { "id_rol" })
})
public class RolUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER")
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "descripcion_rol")
    private String descripcionRol;

}
