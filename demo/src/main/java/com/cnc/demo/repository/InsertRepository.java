package com.cnc.demo.repository;

import com.cnc.demo.model.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsertRepository extends JpaRepository<Insert, Long> {
}