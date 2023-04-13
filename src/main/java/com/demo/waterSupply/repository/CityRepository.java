package com.demo.waterSupply.repository;

import com.demo.waterSupply.model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityModel, Long> {

    CityModel findByCityName(String cityName);
}
