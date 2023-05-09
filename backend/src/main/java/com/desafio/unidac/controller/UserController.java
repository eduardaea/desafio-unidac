package com.desafio.unidac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.unidac.DTO.CreateUserDTO;
import com.desafio.unidac.entities.User;
import com.desafio.unidac.service.user.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping()
    public ResponseEntity insertUser(@RequestBody CreateUserDTO userDTO) {
        try {
            userService.insertUser(userDTO);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity(error.getMessage(), HttpStatus.CONFLICT);
        } 
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@RequestBody CreateUserDTO userDTO, @PathVariable("id") Long id){
        userService.updateUser(userDTO, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
