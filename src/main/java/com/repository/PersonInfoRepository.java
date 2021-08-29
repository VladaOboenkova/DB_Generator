package com.repository;

import com.entity.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PersonInfoRepository extends JpaRepository<PersonInfo, Long> {

    @Query("select p from PersonInfo p where (current_date - p.dob) / 365 >= 18")
    List<PersonInfo> findAllAdults();

    @Query("select p from PersonInfo p where (current_date - p.dob) / 365 < 18")
    List<PersonInfo> findAllChildren();
}
