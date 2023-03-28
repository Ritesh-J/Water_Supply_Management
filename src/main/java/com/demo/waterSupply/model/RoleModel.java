package com.demo.waterSupply.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
@Data
public class RoleModel {
    @Id
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "role_name")
    private String roleName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
    private PermissionModel permissionModel;
//    @Column(name = "permission_id")
//    private int permissionId;
//    @OneToOne(mappedBy = "roleModel",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private UserModel userModel;
    @OneToOne(mappedBy = "roleModel", cascade = CascadeType.ALL)
    private UserModel userModel;


}
