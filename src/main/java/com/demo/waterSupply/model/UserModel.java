package com.demo.waterSupply.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Getter
@Setter
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_address")
    private String userAddress;
//    @Column(name = "password")
//    private String password;
//    @Column(name = "city_id")
//    private int cityId;
//    @Column(name = "role_id")
//    private int roleId;
//    @Column(name = "meter_id")
//    private int meterId;
    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private RoleModel roleModel;
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private CityModel cityModel;
    @OneToOne
    @JoinColumn(name = "meter_id", referencedColumnName = "meter_id")
    private MeterModel meterModel;
}
