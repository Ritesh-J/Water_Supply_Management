package com.demo.waterSupply.repository;

import com.demo.waterSupply.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {


    RoleModel findByRoleName(String roleName);
}
