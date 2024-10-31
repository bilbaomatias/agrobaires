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
@SequenceGenerator(name = "SEQ_IMG", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_IMG")
@Table(name = "IMAGENES", uniqueConstraints = {
        @UniqueConstraint(name = "UK_IMG", columnNames = { "id_img" }),
        @UniqueConstraint(name = "UK_PROD_ID", columnNames = { "id_producto" })
})
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_IMG")
    @Column(name = "id_img")
    private Long idImagen;

    @Column(name = "id_producto")
    private Producto idProducto;

    @Column(name = "img_base64")
    private String imagenBase64;

    @Column(name = "fecha_alta", updatable = false, nullable = false)
    @CreationTimestamp
    private Date fechaDeRegistro;
}
