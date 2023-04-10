package com.demo.waterSupply.repository;

import com.demo.waterSupply.model.MeterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterRepository extends JpaRepository<MeterModel, Integer> {
    MeterModel findByMeterName(String meterName);
}
