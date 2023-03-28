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
@Table(name = "utility")
@Data
public class UtilityModel {
    @Id
    @Column(name = "utility_id")
    private int utilityId;
    @Column(name = "utility_name")
    private String  utilityName;
}
