package com.agrobaires.agrobaires.dao;

import com.agrobaires.agrobaires.entities.Persona;
import com.agrobaires.agrobaires.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonaDAO {
    @Autowired
    PersonaRepository personaRepository;

    public Persona getPersonByCuit(String cuit){
        Persona persona = personaRepository.obtenerPorCuit(cuit);
        return persona;
    }

    public List<Persona> obtenerPersonaPorApellido(String apellido){
        List<Persona> listaPersonaApellido = personaRepository.obtenerPorApellido(apellido);
        return listaPersonaApellido;
    }

    public Persona save(Persona persona){
        personaRepository.save(persona);
        return persona;
    }

}
