package com.agrobaires.agrobaires.dao;

import com.agrobaires.agrobaires.entities.Person;
import com.agrobaires.agrobaires.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonDAO {
    @Autowired
    PersonRepository personRepository;

    public Person getPersonByCuit(String cuit){
        Person persona = personRepository.findByCuit(cuit);
        return persona;
    }


}
