package com.desafio.unidac.DTO;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BreakFastOutputDTO {
    private Long id;
    private String data;
    private List<UserFoodDTO> participants;
}