package com.desafio.unidac.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.unidac.DTO.CreateUserDTO;
import com.desafio.unidac.entities.User;
import com.desafio.unidac.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.getUser(userId);
    }
    
    @Override
    public void insertUser(CreateUserDTO userDTO) {
        userRepository.insertUser(userDTO.getNome(), userDTO.getCpf());
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteUserById(userId);
    }

    @Override
    public void updateUser(CreateUserDTO userDTO, Long userId){
        userRepository.updateUser(userDTO.getCpf(), userDTO.getNome(), userId);
    }
}
