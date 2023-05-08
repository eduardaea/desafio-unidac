package com.desafio.unidac.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafio.unidac.entities.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    @Query(value = "SELECT * FROM Food", nativeQuery = true)
    List<Food> getFoods();
}
