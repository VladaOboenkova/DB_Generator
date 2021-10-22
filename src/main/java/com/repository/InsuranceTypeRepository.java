package com.repository;

import com.entity.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InsuranceTypeRepository extends JpaRepository<InsuranceType, Long> {

    @Query("select itype from InsuranceType itype where itype.name = :name")
    InsuranceType findExistingInsuranceType(@Param("name") String name);
}
