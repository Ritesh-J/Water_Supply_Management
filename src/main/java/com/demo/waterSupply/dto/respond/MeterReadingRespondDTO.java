package com.demo.waterSupply.dto.respond;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MeterReadingRespondDTO {
    private Long readingId;
    private String meterName;
    private Integer meterReading;
    private Integer expectedVolume;
    private Integer lossOfWater;
    private Double percentageLoss;
    private LocalDateTime localDateTime;
}
