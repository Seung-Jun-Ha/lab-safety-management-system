package com.safety.repository;

import com.safety.model.DailyInspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InspectionRepository extends JpaRepository<DailyInspection, Long> {
    List<DailyInspection> findByLabIdAndStatus(String labId, String status);
}