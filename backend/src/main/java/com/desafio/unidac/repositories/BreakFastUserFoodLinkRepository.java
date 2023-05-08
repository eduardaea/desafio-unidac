package com.desafio.unidac.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafio.unidac.entities.BreakFastUserFoodLink;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BreakFastUserFoodLinkRepository extends JpaRepository<BreakFastUserFoodLink, Long> {
    
    @Query(value = "SELECT * FROM breakFastUserFoodLink bfuf " +
        "INNER JOIN Breakfast bk ON bfuf.breakfast_id = bk.id " +
        "INNER JOIN User usr ON usr.id = bfuf.user_id "+
        "INNER JOIN Food fd ON fd.id = bfuf.food_id "+
        "WHERE bk.id =:breakfastId ", nativeQuery = true)
    List<BreakFastUserFoodLink> getBreakFast(@Param("breakfastId") Long breakfastId);
}
