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
@SequenceGenerator(name = "SEQ_CAT_PROD", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_CAT_PROD")
@Table(name = "PRODUCTCATEGORY", uniqueConstraints = {
        @UniqueConstraint(name = "UK_CAT_ID", columnNames = { "id_cat" })
})
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CAT_PROD")
    @Column(name = "id_cat_prod")
    private Long productId;

    @Column(name = "descripcion_cat_prod")
    private String description;

    @Column(name = "id_sub_cat")
    private SubCategory subCategoryId;

    @Column(name = "fecha_alta", updatable = false, nullable = false)
    @CreationTimestamp
    private Date insertionDate;
}
