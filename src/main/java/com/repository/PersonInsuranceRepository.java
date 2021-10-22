package com.repository;

import com.entity.PersonInsurance;
import com.entity.Tourists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonInsuranceRepository extends JpaRepository<PersonInsurance, Long> {

    @Query("select pins from PersonInsurance pins where pins.tourists = :tourists")
    PersonInsurance findPI(@Param("tourists") Tourists tourists);

    @Query("select pins from PersonInsurance pins where pins.policy_num = :policy_num")
    PersonInsurance findPI_PN(@Param("policy_num") String policy_num);
}
