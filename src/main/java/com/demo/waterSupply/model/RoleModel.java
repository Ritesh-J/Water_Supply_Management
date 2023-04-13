package com.demo.waterSupply.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
@Data
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
//    @JsonIgnore
//    private PermissionModel permissionModel;
    @Column(name = "permission_id")
    private int permissionId;
//    @OneToOne(mappedBy = "roleModel",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private UserModel userModel;
//    @OneToOne(mappedBy = "roleModel")
////    @JsonIgnore
//    private UserModel userModel;


}
