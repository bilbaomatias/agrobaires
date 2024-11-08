package com.agrobaires.agrobaires.controller;

import com.agrobaires.agrobaires.dtos.NuevoProductoDTO;
import com.agrobaires.agrobaires.dtos.NuevoUsuarioDTO;
import com.agrobaires.agrobaires.entities.Usuario;
import com.agrobaires.agrobaires.services.AgrobairesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1")
public class Agrobaires {

    @Autowired AgrobairesService agrobairesService;

    @PostMapping(path = "/nuevoUsuario", produces = "application/json")
    @ApiOperation(value = "Registro de nuevo usuario")
    public ResponseEntity<?> nuevoUsuario(@RequestBody final NuevoUsuarioDTO request) throws Exception {
        return agrobairesService.registroNuevoUsuario(request);
    }

    //TODO hacer un endpoint para crear un producto y otro para actualizarlo
    @PostMapping(path = "/nuevoProducto", produces = "application/json")
    @ApiOperation(value = "Creación de un producto nuevo")
    public ResponseEntity<?> nuevoProducto(@RequestBody final NuevoProductoDTO request) throws Exception {
        return agrobairesService.registroNuevoProducto(request);
    }

    @PutMapping(path = "/actualizarProducto/{idProducto}", produces = "application/json")
    @ApiOperation(value = "Actualizacion de un producto.")
    public ResponseEntity<?> actualizarProducto(@PathVariable final String productoId,
                                                @RequestBody final NuevoProductoDTO producto) throws Exception {
        return agrobairesService.actualizarProducto(productoId, producto);
    }

}
