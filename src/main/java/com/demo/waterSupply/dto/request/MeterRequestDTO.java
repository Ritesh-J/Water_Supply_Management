package com.demo.waterSupply.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MeterRequestDTO {
    private String meterName;
    private Long criticalVolume;
    private Long crossSecArea;
    private Long locationPin;
    private String cityName;
}
