package com.desafio.unidac.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desafio.unidac.entities.Breakfast;

public interface BreakfastRepository extends JpaRepository<Breakfast, Long> {

    @Query(value = "SELECT * FROM Breakfast", nativeQuery = true)
    List<Breakfast> getAllBreakfasts();

    @Query(value ="SELECT FROM Breakfast b WHERE b.id = :id", nativeQuery = true)
    Breakfast getBreakfast(@Param("id")Long id);

    @Query(value="INSERT INTO Breakfast (data) VALUES (:data)",nativeQuery = true)
    Breakfast createBreakfast(@Param("data")Date data);

}
