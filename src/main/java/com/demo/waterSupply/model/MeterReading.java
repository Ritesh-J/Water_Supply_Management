package com.demo.waterSupply.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "meter_reading")
@Data
public class MeterReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reading_id")
    private Long readingId;
//    @Column(name = "meter_id")
//    private int meterId;
    @Column(name = "meter_reading")
    private int meterReading;
    @Column(name = "expected_volume")
    private Integer expectedVolume=0;
    @Column(name = "loss_of_water")
    private Integer lossOfWater=0;
    @Column(name = "percentage_loss")
    private Double percentageLoss=0.0;
    @Column(name = "time_stamp")
    private LocalDateTime localDateTime;
    @OneToOne
    @JoinColumn(name = "meter_id", referencedColumnName = "meter_id")
    private MeterModel meterModel;
}
