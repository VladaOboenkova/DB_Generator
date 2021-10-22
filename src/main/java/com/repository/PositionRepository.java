package com.repository;

import com.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PositionRepository extends JpaRepository<Position, Long> {

    @Query("select p from Position p where p.position_name = :position_name")
    Position findExistingPosition(@Param("position_name") String position_name);
}
