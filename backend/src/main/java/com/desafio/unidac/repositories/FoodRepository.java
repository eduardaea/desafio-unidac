package com.desafio.unidac.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafio.unidac.entities.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    @Query(value = "SELECT * FROM food WHERE NOT EXISTS" +
        "(SELECT * FROM breakfastuserfoodlink bfuf WHERE bfuf.breakfast_id = :breakfastId AND bfuf.food_id = food.id)", nativeQuery = true)
    List<Food> getFoods(@Param("breakfastId") Long breakfastId);
}
