package com.demo.waterSupply.repository;

import com.demo.waterSupply.model.PermissionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionModel, Integer> {
}
