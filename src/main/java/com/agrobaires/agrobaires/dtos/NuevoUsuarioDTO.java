package com.agrobaires.agrobaires.dtos;

import com.agrobaires.agrobaires.entities.RolUsuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NuevoUsuarioDTO {
    private String nombreUsuario;
    private String telefono;
    private String email;
    private String domicilio;
    private RolUsuario rolUsuario;
    private String contraseña;
    private String nombres;
    private String apellido;
    private String cuit;

}
