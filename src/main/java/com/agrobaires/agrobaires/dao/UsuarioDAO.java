package com.agrobaires.agrobaires.dao;

import com.agrobaires.agrobaires.entities.Usuario;
import com.agrobaires.agrobaires.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioDAO {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario getUser(String input){
        Usuario usuario = null;
        usuario = usuarioRepository.obtenerUsuarioPorNombreUsuario(input);
        if(usuario == null){
            usuario = usuarioRepository.obtenerUsuarioPorEmail(input);
        }
        return usuario;
    }

    public List<Usuario> getListUsersByRole(String rol){
        List<Usuario> usuarios = usuarioRepository.obtenerUsuarioPorRol(rol);
        return usuarios;
    }

    public Usuario saveUser(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerTodoUsuario(){
        return usuarioRepository.findAll();
    }

}
