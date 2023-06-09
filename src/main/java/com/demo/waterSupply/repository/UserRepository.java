package com.demo.waterSupply.repository;

import com.demo.waterSupply.model.MeterModel;
import com.demo.waterSupply.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    boolean existsByUserEmail(String userEmail);

    UserModel findByUserEmail(String emailToVerify);

    List<UserModel> findByMeterModel(MeterModel meterModel);

//    List<UserModel> findByMeterName(String meterName);
}
