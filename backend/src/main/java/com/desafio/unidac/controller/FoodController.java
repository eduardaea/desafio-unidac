package com.desafio.unidac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.unidac.entities.Food;
import com.desafio.unidac.service.food.FoodService;

@RestController
@RequestMapping("/food")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Food>> getFoods(@PathVariable("id") Long breakfastId) {
        return ResponseEntity.ok(foodService.getAllFoods(breakfastId));
    }
}
