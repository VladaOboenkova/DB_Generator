package com.repository;

import com.entity.TourStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TourStaffRepository extends JpaRepository<TourStaff, Long> {
}
