package com.repository;

import com.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    @Query("select i from Insurance i where i.name = :name")
    Insurance findExistingInsurance(@Param("name") String name);
}
