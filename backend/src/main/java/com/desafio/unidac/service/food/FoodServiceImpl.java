package com.desafio.unidac.service.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.unidac.entities.Food;
import com.desafio.unidac.repositories.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> getAllFoods(Long breakfastId) {
        return foodRepository.getFoods(breakfastId);
    }
}
