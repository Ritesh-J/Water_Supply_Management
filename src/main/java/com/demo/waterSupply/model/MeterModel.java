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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meter_id")
    private Long meterId;
    @Column(name = "meter_name")
    private String meterName;
    @Column(name = "meter_reading")
    private Integer meterReading=0;
    @Column(name = "critical_volume")
    private Long criticalVolume;
    @Column(name="cross_sectional_area")
    private Long crossSecArea;
    @Column(name = "location_pin")
    private Long locationPin;
    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private CityModel cityModel;
//    @OneToMany(mappedBy = "source")
//    private List<WaterMeterMapping> mappings1;
//    @OneToMany(mappedBy = "target")
//    private List<WaterMeterMapping> mappings2;



}
