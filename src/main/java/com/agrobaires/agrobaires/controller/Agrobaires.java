package com.agrobaires.agrobaires.controller;

import com.agrobaires.agrobaires.dtos.NuevoUsuarioDTO;
import com.agrobaires.agrobaires.services.AgrobairesService;
import io.swagger.annotations.ApiOperation;
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
}
