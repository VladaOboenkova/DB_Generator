package com.repository;

import com.entity.TypeOfRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TypeOfRoomRepository extends JpaRepository<TypeOfRoom, Long> {

    @Query("select tor from TypeOfRoom tor where tor.type_of_room = :type_of_room")
    TypeOfRoom findExistingToR(@Param("type_of_room") String type_of_room);
}
