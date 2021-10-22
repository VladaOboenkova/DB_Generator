package com.repository;

import com.entity.TypeOfFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TypeOfFoodRepository extends JpaRepository<TypeOfFood, Long> {

    @Query("select tof from TypeOfFood tof where tof.type_of_food = :type_of_food")
    TypeOfFood findExistingToF(@Param("type_of_food") String type_of_food);

}
