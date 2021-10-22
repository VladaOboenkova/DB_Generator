package com.repository;


import com.entity.AddService;
import com.entity.ChoosenService;
import com.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChoosenServiceRepository extends JpaRepository<ChoosenService, Long> {

    @Query("select cs from ChoosenService cs where cs.id_order = :id_order and cs.id_add_service = :id_add_service")
    ChoosenService findExistingCS(@Param("id_order") Order id_order,
                                  @Param("id_add_service") AddService id_add_service);

    @Query("select cs from ChoosenService cs where cs.id_order = :id_order")
    List<ChoosenService> allChoosenServices(@Param("id_order") Order id_order);
}
