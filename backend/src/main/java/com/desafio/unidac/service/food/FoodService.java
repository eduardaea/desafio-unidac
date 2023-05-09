package com.desafio.unidac.service.food;

import java.util.List;

import com.desafio.unidac.entities.Food;

public interface FoodService {
    List<Food> getAllFoods(Long breakfastId);
}
