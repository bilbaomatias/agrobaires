package com.agrobaires.agrobaires.dao;

import com.agrobaires.agrobaires.entities.User;
import com.agrobaires.agrobaires.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDAO {
    @Autowired
    UserRepository userRepository;

    public User getUser(String input){
        User user = null;
        user = userRepository.findUserByUsername(input);
        if(user == null){
            user = userRepository.findUserByEmail(input);
        }
        return user;
    }

    public List<User> getListUsersByRole(String rol){
        List<User> users = userRepository.findAllUserByRole(rol);
        return users;
    }

    public User saveUser(User usuario){
        return userRepository.save(usuario);
    }

}
