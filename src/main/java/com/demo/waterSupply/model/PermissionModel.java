package com.demo.waterSupply.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permission")
@Data
public class PermissionModel {
    @Id
    @Column(name = "permission_id")
    private int permissionId;
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "meter_id")
    private int meterId;
    @Column(name = "upload_user")
    private boolean uploadUser;
    @Column(name = "upload_employee")
    private boolean uploadEmployee;
    @Column(name = "upload_city")
    private boolean uploadCity;
    @Column(name = "upload_reading")
    private boolean uploadReading;
    @Column(name="upload_map")
    private boolean uploadMap;
    @Column(name="view_reading")
    private boolean viewReading;

//    @OneToOne(mappedBy = "permissionModel")
//    private RoleModel roleModel;


}
