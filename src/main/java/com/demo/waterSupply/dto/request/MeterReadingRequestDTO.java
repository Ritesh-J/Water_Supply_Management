package com.demo.waterSupply.dto.request;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MeterReadingRequestDTO {
    private String meterName;
    private Integer meterReading;
}
