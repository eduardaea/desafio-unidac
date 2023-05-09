package com.desafio.unidac.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desafio.unidac.entities.Breakfast;

public interface BreakfastRepository extends JpaRepository<Breakfast, Long> {

    @Query(value = "SELECT * FROM breakfast", nativeQuery = true)
    List<Breakfast> getAllBreakfasts();

    @Modifying
    @Transactional
    @Query(value="INSERT INTO breakfast (data) VALUES (:data)",nativeQuery = true)
    void createBreakfast(@Param("data") Date data);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM breakfast brk WHERE brk.id = :id", nativeQuery = true)
    void deleteBreakfastById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE breakfast SET data = :data WHERE id = :breakfastId", nativeQuery = true)
    void updateBreakfast(@Param("data") Date data, @Param("breakfastId") long id);
}
