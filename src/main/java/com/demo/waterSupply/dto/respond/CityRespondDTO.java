package com.demo.waterSupply.dto.respond;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CityRespondDTO {
    private Long cityId;
    private String cityName;
    private String utilityName;
}
