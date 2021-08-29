package com.repository;

import com.entity.PersonInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonInsuranceRepository extends JpaRepository<PersonInsurance, Long> {
}
