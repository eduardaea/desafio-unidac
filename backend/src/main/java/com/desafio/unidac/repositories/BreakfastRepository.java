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

    @Query(value = "SELECT * FROM Breakfast", nativeQuery = true)
    List<Breakfast> getAllBreakfasts();

    @Modifying
    @Transactional
    @Query(value="INSERT INTO Breakfast (data) VALUES (:data)",nativeQuery = true)
    Breakfast createBreakfast(@Param("data")Date data);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Breakfast breakfast WHERE breakfast.id = :id", nativeQuery = true)
    void deleteBreakfastById(@Param("id") Long id);

}
