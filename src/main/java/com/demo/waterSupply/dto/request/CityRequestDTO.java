package com.demo.waterSupply.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CityRequestDTO {
    private String cityName;
    private String utilityName;

}
