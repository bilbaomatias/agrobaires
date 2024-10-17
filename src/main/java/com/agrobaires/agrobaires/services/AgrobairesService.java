package com.agrobaires.agrobaires.services;

import com.agrobaires.agrobaires.repositories.PersonRepository;
import com.agrobaires.agrobaires.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AgrobairesService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    UserRepository userRepository;
}
