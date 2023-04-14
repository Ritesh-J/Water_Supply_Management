package com.demo.waterSupply.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "water_meter_mapping")
@Data
public class WaterMeterMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mappingId;
    @ManyToOne
    @JoinColumn(name = "source")
    private MeterModel source;
    @ManyToOne
    @JoinColumn(name = "target")
    private MeterModel target;
}
