package com.agrobaires.agrobaires.services;

import com.agrobaires.agrobaires.context.UserStatus;
import com.agrobaires.agrobaires.dao.PersonaDAO;
import com.agrobaires.agrobaires.dao.UsuarioDAO;
import com.agrobaires.agrobaires.dtos.NuevoUsuarioDTO;
import com.agrobaires.agrobaires.entities.Persona;
import com.agrobaires.agrobaires.entities.Usuario;
import com.agrobaires.agrobaires.repositories.PersonaRepository;
import com.agrobaires.agrobaires.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class AgrobairesService {

    /** Repositorios */
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    /** DAOs */

    @Autowired
    UsuarioDAO usuarioDAO;
    @Autowired
    PersonaDAO personaDAO;

    /** ServicioValidacion */
    @Autowired Validaciones validaciones;



    public ResponseEntity<?> registroNuevoUsuario (NuevoUsuarioDTO request) throws Exception {

        if(!validaciones.isEmailValido(request.getEmail())){
            throw new Exception("Error en el formato del email. Por favor ingresá uno válido.");
        }
        if(!validaciones.validarNumeroTelefono(request.getTelefono())){
            throw new Exception("Error en el formato de teléfono. Por favor ingresá los 10 números");
        }
        if(!validaciones.validarFormatoCuit(request.getCuit())){
            throw new Exception("Error en el formato de la CUIT. Por favor ingresá solo 11 números.");
        }

        Usuario usuario = usuarioDAO.getUser(request.getEmail());
        if(Objects.nonNull(usuario)) throw new Exception("El usuario ya está registrado.");

        registrarUsuario(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(request.builder());
    }

    /** El transactional es por si hay algun error, se revierte toda la operacion
     * y no quedan inconsistencias en la BBDD.
     */
    @Transactional
    private Usuario registrarUsuario(NuevoUsuarioDTO request){
        Usuario nuevoUsuario = null;

        nuevoUsuario.setNombreUsuario(request.getNombreUsuario());
        nuevoUsuario.setTelefono(request.getTelefono());
        nuevoUsuario.setEmail(request.getEmail());
        nuevoUsuario.setDomicilio(request.getDomicilio());
        nuevoUsuario.setContraseña(request.getContraseña());
        nuevoUsuario.setRolUsuario(request.getRolUsuario());
        nuevoUsuario.setEstado(UserStatus.ACTIVE);
        nuevoUsuario.setIdPersona(
                registrarPersona(request.getNombres(), request.getApellido(), request.getCuit()));
        ;

        return usuarioDAO.saveUser(nuevoUsuario);
    }

    private Persona registrarPersona(String nombres, String apellido, String cuit){
        Persona nuevaPersona = null;
        nuevaPersona.setNombres(nombres);
        nuevaPersona.setApellido(apellido);
        nuevaPersona.setCuit(cuit);

        return personaDAO.save(nuevaPersona);
    }

}
