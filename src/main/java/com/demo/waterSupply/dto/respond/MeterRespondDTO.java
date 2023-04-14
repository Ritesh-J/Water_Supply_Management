package com.demo.waterSupply.dto.respond;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MeterRespondDTO {
    private Long meterId;
    private String meterName;
    private Long criticalVolume;
    private Long crossSecArea;
    private Long locationPin;
    private String cityName;
}
