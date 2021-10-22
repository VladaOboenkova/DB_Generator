package com.repository;

import com.entity.Client;
import com.entity.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.id_person_info = :id_person_info")
    Client findExistingClient(@Param("id_person_info") PersonInfo id_person_info);

    @Query("select c from Client c where c.passport_num = :passport_num and c.passport_series = :passport_series")
    Client findExistingClientByPassport(@Param("passport_num") String passport_num,
                                        @Param("passport_series") String passport_series);
}
