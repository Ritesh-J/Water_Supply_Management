package com.demo.waterSupply.repository;

import com.demo.waterSupply.model.UtilityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilityRepository extends JpaRepository<UtilityModel, Long> {
    UtilityModel findByUtilityName(String utilityName);

    Boolean existsByUtilityName(String utilityName);
}
