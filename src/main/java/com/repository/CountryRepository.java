package com.repository;

import com.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("select c from Country c where c.name = :name")
    Country findExistingCountry(@Param("name") String name);
}
