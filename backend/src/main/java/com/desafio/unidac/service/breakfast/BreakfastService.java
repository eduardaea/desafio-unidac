package com.desafio.unidac.service.breakfast;

import java.util.List;

import com.desafio.unidac.DTO.BreakFastOutputDTO;
import com.desafio.unidac.DTO.CreateBreakFastDTO;
import com.desafio.unidac.DTO.InputUserFoodDTO;

public interface BreakfastService {
    List<BreakFastOutputDTO> getBreakfasts();
    BreakFastOutputDTO getBreakfast(Long breakfastId);
    void insertBreakfast(CreateBreakFastDTO breakFastDTO);
    void deleteBreakfast(Long breakFastId);
    void insertUserFood(Long breakfastId, InputUserFoodDTO userFoodDto);
}
