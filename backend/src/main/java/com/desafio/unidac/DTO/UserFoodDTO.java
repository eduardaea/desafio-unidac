package com.desafio.unidac.DTO;

import com.desafio.unidac.entities.Food;
import com.desafio.unidac.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFoodDTO {
    private User user;
    private Food food;
}
