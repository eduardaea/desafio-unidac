package com.desafio.unidac.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafio.unidac.entities.BreakFastUserFoodLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

@Repository
public interface BreakFastUserFoodLinkRepository extends JpaRepository<BreakFastUserFoodLink, Long> {
    
    @Query(value = "SELECT * FROM breakfastuserfoodlink bfuf " +
        "INNER JOIN Breakfast bk ON bfuf.breakfast_id = bk.id " +
        "INNER JOIN User usr ON usr.id = bfuf.user_id "+
        "INNER JOIN Food fd ON fd.id = bfuf.food_id "+
        "WHERE bk.id =:breakfastId ", nativeQuery = true)
    List<BreakFastUserFoodLink> getBreakFast(@Param("breakfastId") Long breakfastId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO breakfastuserfoodlink (user_id, food_id, breakfast_id) " +
        "SELECT :userId, :foodId, :breakfastId " +
        "WHERE NOT EXISTS (SELECT 1 FROM breakfastuserfoodlink bfuf WHERE bfuf.food_id = :foodId AND bfuf.breakfast_id = :breakfastId)"
        , nativeQuery = true)
    int insertUserFood(@Param("breakfastId") Long breakfastId, @Param("foodId") Long foodId, @Param("userId") Long userId);
}
