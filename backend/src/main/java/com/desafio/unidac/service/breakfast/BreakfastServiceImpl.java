package com.desafio.unidac.service.breakfast;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.unidac.DTO.BreakFastOutputDTO;
import com.desafio.unidac.DTO.CreateBreakFastDTO;
import com.desafio.unidac.DTO.InputUserFoodDTO;
import com.desafio.unidac.DTO.UserFoodDTO;
import com.desafio.unidac.entities.BreakFastUserFoodLink;
import com.desafio.unidac.entities.Breakfast;
import com.desafio.unidac.repositories.BreakfastRepository;
import com.desafio.unidac.repositories.BreakFastUserFoodLinkRepository;

@Service
public class BreakfastServiceImpl implements BreakfastService{
    
    @Autowired
    private BreakfastRepository breakfastRepository;
    
    @Autowired
    private BreakFastUserFoodLinkRepository BreakFastUserFoodLinkRepository;

    @Override
    public List<BreakFastOutputDTO> getBreakfasts() {
        List<Breakfast> breakfasts = breakfastRepository.getAllBreakfasts();
        List<BreakFastOutputDTO> breakFastOutputList = new ArrayList<BreakFastOutputDTO>();

        for (Breakfast breakfast: breakfasts) {
            BreakFastOutputDTO breakFastOutput = new BreakFastOutputDTO();
            breakFastOutput.setId(breakfast.getId());
            breakFastOutput.setData(breakfast.getData().toString());

            breakFastOutputList.add(breakFastOutput);
        }

        return breakFastOutputList;
    }

    @Override
    public BreakFastOutputDTO getBreakfast(Long breakfastId) {
        List<BreakFastUserFoodLink> breakFastUserFoodLinks = BreakFastUserFoodLinkRepository.getBreakFast(breakfastId);
        BreakFastOutputDTO breakfast = new BreakFastOutputDTO();

        breakfast.setParticipants(new ArrayList<UserFoodDTO>());

        for (BreakFastUserFoodLink breakFastUserFoodLink: breakFastUserFoodLinks) {
            if (breakfast.getData() == null && breakfast.getId() == null) {
                breakfast.setId(breakFastUserFoodLink.getBreakfast().getId());
                breakfast.setData(breakFastUserFoodLink.getBreakfast().getData().toString());
            }

            UserFoodDTO userFoodDTO = new UserFoodDTO();
            userFoodDTO.setFood(breakFastUserFoodLink.getFood());
            userFoodDTO.setUser(breakFastUserFoodLink.getUser());
            breakfast.getParticipants().add(userFoodDTO);
        }

        return breakfast;
    }

    @Override
    public void insertUserFood(Long breakfastId, InputUserFoodDTO userFoodDto) throws Exception {
        int inserted = BreakFastUserFoodLinkRepository.insertUserFood(breakfastId, userFoodDto.getFoodId(), userFoodDto.getUserId());

        if (inserted == 0) {
            throw new Exception("Essa comida já foi escolhida");
        }
    }

    @Override
    public void updateBreakfast(CreateBreakFastDTO updateBreakfast, long id) {
        breakfastRepository.updateBreakfast(updateBreakfast.getData(), id);
    }

    @Override
    public void insertBreakfast(CreateBreakFastDTO breakFastDTO) {
        breakfastRepository.createBreakfast(breakFastDTO.getData());
    }

    @Override
    public void deleteBreakfast(Long breakFastId) {
        BreakFastUserFoodLinkRepository.deleteBreakfast(breakFastId);
        breakfastRepository.deleteBreakfastById(breakFastId);
    }
}
