package com.repository;

import com.entity.AddService;
import com.entity.Tour;
import com.entity.TourAddService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourAddServiceRepository extends JpaRepository<TourAddService, Long> {

    @Query("select tas from TourAddService tas where tas.id_tour = :id_tour and tas.id_add_service = :id_add_service")
    TourAddService findExistingTAS(@Param("id_tour") Tour id_tour,
                                   @Param("id_add_service") AddService id_add_service);

    @Query("select tas from TourAddService tas where tas.id_tour = :id_tour")
    List<TourAddService> findTAS(@Param("id_tour") Tour id_tour);
}
