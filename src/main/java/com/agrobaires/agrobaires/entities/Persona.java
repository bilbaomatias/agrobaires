package com.agrobaires.agrobaires.entities;

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
@SequenceGenerator(name = "SEQ_PERSON", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_PERSON")
@Table(name = "PERSONA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_PERSON", columnNames = { "cuit" })
})
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERSON")
    @Column(name = "id_persona")
    private Long idPersona;

    @Column(name = "nombre")
    private String nombres;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "cuit")
    private String cuit;

    @Column(name = "fecha_alta", updatable = false, nullable = false)
    @CreationTimestamp
    private Date fechaDeRegistro;

}
