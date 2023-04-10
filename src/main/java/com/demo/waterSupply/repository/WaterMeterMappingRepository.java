package com.demo.waterSupply.repository;

import com.demo.waterSupply.model.MeterModel;
import com.demo.waterSupply.model.WaterMeterMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterMeterMappingRepository extends JpaRepository<WaterMeterMapping, Long> {
    List<WaterMeterMapping> findBySource(MeterModel meterModel);
    List<WaterMeterMapping> findByTarget(MeterModel meterModel);
}
