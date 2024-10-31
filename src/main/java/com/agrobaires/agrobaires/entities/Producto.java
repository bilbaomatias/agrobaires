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
@SequenceGenerator(name = "SEQ_PRODUCT", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_PRODUCT")
@Table(name = "PRODUCTO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_ID_PRODUCTO", columnNames = { "id_producto"}),
        @UniqueConstraint(name = "UK_CAT_PRODUCTO", columnNames = { "id_cat_prod"})
})
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT")
    @Column(name = "id_producto")
    private Long productId;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "id_cat_prod")
    private Long productCatId;

    @Column(name = "precio")
    private String price;

    private Integer stock;

    @Column(name = "id_img")
    private Long imageId;

    @Column(name = "fecha_alta", updatable = false, nullable = false)
    @CreationTimestamp
    private Date insertionDate;
}
