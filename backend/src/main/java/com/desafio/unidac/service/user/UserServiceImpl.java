package com.desafio.unidac.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.unidac.DTO.CreateUserDTO;
import com.desafio.unidac.entities.User;
import com.desafio.unidac.repositories.UserRepository;
import com.desafio.unidac.repositories.BreakFastUserFoodLinkRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BreakFastUserFoodLinkRepository BreakFastUserFoodLinkRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.getUser(userId);
    }
    
    @Override
    public void insertUser(CreateUserDTO userDTO) throws Exception {
        int inserted = userRepository.insertUser(userDTO.getNome(), userDTO.getCpf());

        if (inserted == 0) {
            throw new Exception("Já existe um usuário com esse cpf");
        }
    }

    @Override
    public void deleteUser(Long userId) {
        BreakFastUserFoodLinkRepository.deleteBreakfastByUser(userId);
        userRepository.deleteUserById(userId);
    }

    @Override
    public void updateUser(CreateUserDTO userDTO, Long userId){
        userRepository.updateUser(userDTO.getCpf(), userDTO.getNome(), userId);
    }
}
