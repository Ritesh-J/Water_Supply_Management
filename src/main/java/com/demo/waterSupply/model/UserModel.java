package com.demo.waterSupply.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Data
public class UserModel {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_address")
    private String userAddress;
    @Column(name = "city_id")
    private int cityId;
//    @Column(name = "role_id")
//    private int roleId;
    @Column(name = "meter_id")
    private int meterId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private RoleModel roleModel;
}
