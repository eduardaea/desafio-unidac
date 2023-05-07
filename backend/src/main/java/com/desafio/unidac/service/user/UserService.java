package com.desafio.unidac.service.user;

import java.util.List;

import com.desafio.unidac.DTO.CreateUserDTO;
import com.desafio.unidac.entities.User;

public interface UserService {
    List<User> getUsers();
    User getUser(Long userId);
    void insertUser(CreateUserDTO userDTO);
    void deleteUser(Long userId);
}
