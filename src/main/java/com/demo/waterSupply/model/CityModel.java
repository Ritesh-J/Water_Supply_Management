package com.demo.waterSupply.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "city")
@Data
public class CityModel {
    @Id
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "city_name")
    private String  cityName;
    @Column(name = "utility_id")
    private int utilityId;

}
