package com.agrobaires.agrobaires.services;

import com.agrobaires.agrobaires.context.UserStatus;
import com.agrobaires.agrobaires.dao.PersonaDAO;
import com.agrobaires.agrobaires.dao.ProductoDAO;
import com.agrobaires.agrobaires.dao.UsuarioDAO;
import com.agrobaires.agrobaires.dtos.NuevoProductoDTO;
import com.agrobaires.agrobaires.dtos.NuevoUsuarioDTO;
import com.agrobaires.agrobaires.entities.Persona;
import com.agrobaires.agrobaires.entities.Producto;
import com.agrobaires.agrobaires.entities.Usuario;
import com.agrobaires.agrobaires.repositories.PersonaRepository;
import com.agrobaires.agrobaires.repositories.UsuarioRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.DataInput;
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
    @Autowired
    ProductoDAO productoDAO;

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

        //Antes de registrar el usuario, registro persona y le asigno el idPersona
        nuevoUsuario.setIdPersona(
                registrarPersona(request.getNombres(), request.getApellido(), request.getCuit()));

        return usuarioDAO.saveUser(nuevoUsuario);
    }

    private Persona registrarPersona(String nombres, String apellido, String cuit){
        Persona nuevaPersona = null;
        nuevaPersona.setNombres(nombres);
        nuevaPersona.setApellido(apellido);
        nuevaPersona.setCuit(cuit);

        return personaDAO.save(nuevaPersona);
    }

    public ResponseEntity<?> registroNuevoProducto(NuevoProductoDTO req) throws Exception {
        Producto nuevoProducto = null;
        if(Objects.isNull(req) || req.getDescription().isBlank() || req.getDescription().isEmpty())
            throw new Exception("Error en los datos del producto. Por favor intentá nuevamente.");

        nuevoProducto.setDescription(req.getDescription());

        //como los demas campos son opcionales, hacer control de nulidad
        nuevoProducto.setProductCatId(req.getProductCatId() != null ? req.getProductCatId() : null);
        nuevoProducto.setStock(req.getStock() != null ? req.getStock() : null);
        nuevoProducto.setPrice(req.getPrice() != null ? req.getPrice().toString() : null);
        nuevoProducto.setStock(req.getStock() != null ? Integer.valueOf(req.getStock()) : null);
        nuevoProducto.setImageId(req.getImageId() != null ? req.getImageId() : null);

        return ResponseEntity.ok().body(productoDAO.saveProducto(nuevoProducto));
    }

    public ResponseEntity<?> actualizarProducto(String productoId, NuevoProductoDTO prod) throws Exception {
        if(productoId.isEmpty() || productoId.isBlank() || Objects.isNull(prod))
            throw new Exception("Error en los datos del producto. Por favor intentá nuevamente.");

        Producto updProducto = productoDAO.getProductoPorId(Long.valueOf(productoId));

        updProducto.setDescription(prod.getDescription() != null ? prod.getDescription(): updProducto.getDescription());
        updProducto.setProductCatId(prod.getProductCatId() != null ? prod.getProductCatId() : updProducto.getProductId());
        updProducto.setStock(prod.getStock() != null ? prod.getStock() : updProducto.getStock());
        updProducto.setPrice(prod.getPrice() != null ? prod.getPrice().toString() : updProducto.getPrice());
        updProducto.setStock(prod.getStock() != null ? Integer.valueOf(prod.getStock()) : updProducto.getStock());
        updProducto.setImageId(prod.getImageId() != null ? prod.getImageId() : updProducto.getImageId());

        Producto actualizado = productoDAO.saveProducto(updProducto);

        return ResponseEntity.ok().body(actualizado);
    }

}
