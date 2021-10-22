package com.repository;

import com.entity.AddService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddServiceRepository extends JpaRepository<AddService, Long> {

    @Query("select ads from AddService ads where ads.name = :name")
    AddService findExistingAddService(@Param("name") String name);
}
