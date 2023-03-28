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
@Table(name = "meter")
@Data
public class MeterModel {
    @Id
    @Column(name = "meter_id")
    private int meterId;
    @Column(name = "meter_name")
    private String meterName;
    @Column(name = "critical_volume")
    private int criticalVolume;
    @Column(name="cross_sectional_area")
    private int crossSecArea;
    @Column(name = "location_pin")
    private int locationPin;


}
