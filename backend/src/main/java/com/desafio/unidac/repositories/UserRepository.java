package com.desafio.unidac.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafio.unidac.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM User user WHERE user.id = :userId", nativeQuery = true)
    User getUser(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM User", nativeQuery = true)
    List<User> getAllUsers();

    @Modifying
    @Transactional
    @Query(value = "insert into User (nome, cpf) values (:nome, :cpf)",
    nativeQuery = true)
    void insertUser(@Param("nome") String nome, @Param("cpf") String cpf);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM User user where user.id =:userId", nativeQuery = true)
    void deleteUserById(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM User user where user.cpf = :cpf", nativeQuery = true)
    void deleteUserByCpf(@Param("cpf") String cpf);
}