package com.desafio.unidac.DTO;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BreakFastOutputDTO {
    private Long id;
    private Date data;
    private List<UserFoodDTO> usersFoods;
}