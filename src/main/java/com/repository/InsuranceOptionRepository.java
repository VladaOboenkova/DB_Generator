package com.repository;

import com.entity.Insurance;
import com.entity.InsuranceOption;
import com.entity.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InsuranceOptionRepository extends JpaRepository<InsuranceOption, Long> {

    @Query("select iop from InsuranceOption iop where iop.id_insurance = :id_insurance" +
            " and iop.id_insurance_type = :id_insurance_type")
    InsuranceOption findExistingIO(@Param("id_insurance") Insurance id_insurance,
                                    @Param("id_insurance_type") InsuranceType id_insurance_type);
}
