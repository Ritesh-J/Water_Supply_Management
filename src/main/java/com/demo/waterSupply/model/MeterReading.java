package com.demo.waterSupply.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "reading_id")
    private int readingId;
    @Column(name = "meter_id")
    private int meterId;
    @Column(name = "meter_reading")
    private int meterReading;
    @Column(name = "time_stamp")
    private LocalDateTime localDateTime;
}
