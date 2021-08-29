package com.repository;

import com.entity.InsuranceCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceCaseRepository extends JpaRepository<InsuranceCase, Long> {
}
