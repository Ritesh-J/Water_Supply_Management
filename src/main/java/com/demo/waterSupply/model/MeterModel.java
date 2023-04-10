package com.demo.waterSupply.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
//    @OneToMany(mappedBy = "source")
//    private List<WaterMeterMapping> mappings1;
//    @OneToMany(mappedBy = "target")
//    private List<WaterMeterMapping> mappings2;



}
