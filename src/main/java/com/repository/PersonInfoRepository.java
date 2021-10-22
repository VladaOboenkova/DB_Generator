package com.repository;

import com.entity.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonInfoRepository extends JpaRepository<PersonInfo, Long> {

    @Query("select p from PersonInfo p where (current_date - p.dob) / 365 >= 18")
    List<PersonInfo> findAllAdults();

    @Query("select p from PersonInfo p where (current_date - p.dob) / 365 < 18")
    List<PersonInfo> findAllChildren();

    @Query("select p from PersonInfo p where p.phone = :phone")
    PersonInfo findPIByPhone(@Param("phone") String phone);

    @Query("select p from PersonInfo p where p.email = :email")
    PersonInfo findPIByEmail(@Param("email") String email);

    @Query("select p from PersonInfo p where p.intl_passport_num = :intl_passport_num " +
            "and p.intl_passport_series = :intl_passport_series")
    PersonInfo findPIByPassport(@Param("intl_passport_num") String intl_passport_num,
                                @Param("intl_passport_series") String intl_passport_series);
}
