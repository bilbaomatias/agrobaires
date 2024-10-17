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
@SequenceGenerator(name = "SEQ_SUBCAT", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_SUBCAT")
@Table(name = "SUBCATEGORY", uniqueConstraints = {
        @UniqueConstraint(name = "UK_SUBCAT_ID", columnNames = { "id_sub_cat" }),
        @UniqueConstraint(name = "UK_CAT_ID", columnNames = { "id_cat" })
})
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SUBCAT")
    @Column(name = "id_sub_cat")
    private Long subCategoryId;

    @Column(name = "nombre_sub_cat")
    private String subCategoryName;

    @Column(name = "id_cat")
    private Long categoryId;

    @Column(name = "fecha_alta", updatable = false, nullable = false)
    @CreationTimestamp
    private Date insertionDate;
}
