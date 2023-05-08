package com.desafio.unidac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafio.unidac.DTO.BreakFastOutputDTO;
import com.desafio.unidac.DTO.CreateBreakFastDTO;
import com.desafio.unidac.entities.Breakfast;
import com.desafio.unidac.service.breakfast.BreakfastService;

@Controller
@RequestMapping("/breakfast")
public class BreakfastController {

    @Autowired
    private BreakfastService breakfastService;

    @GetMapping
    public ResponseEntity<List<Breakfast>> getBreakFasts() {
        return ResponseEntity.ok(breakfastService.getBreakfasts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BreakFastOutputDTO> getBreakFast(@PathVariable("id") Long id) {
        return ResponseEntity.ok(breakfastService.getBreakfast(id));
    }

    @PostMapping()
    public void insertBreakfast(@RequestBody CreateBreakFastDTO breakfastDTO) {
        breakfastService.insertBreakfast(breakfastDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBreakfast(@PathVariable("id") Long id) {
        breakfastService.deleteBreakfast(id);
    }
}