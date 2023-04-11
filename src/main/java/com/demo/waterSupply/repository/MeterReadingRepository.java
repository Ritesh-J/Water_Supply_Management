package com.demo.waterSupply.repository;

import com.demo.waterSupply.model.MeterReading;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterReadingRepository extends JpaRepository<MeterReading, Integer> {

}
