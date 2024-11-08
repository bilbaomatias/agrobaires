package com.agrobaires.agrobaires.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NuevoProductoDTO {
    @ApiModelProperty(required = true)
    private String description;
    @ApiModelProperty(required = false)
    private Long productCatId;
    @ApiModelProperty(required = false)
    private Long price;
    @ApiModelProperty(required = false)
    private Integer stock;
    @ApiModelProperty(required = false)
    private Long imageId;
}
