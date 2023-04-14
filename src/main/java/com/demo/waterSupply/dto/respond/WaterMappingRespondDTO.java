package com.demo.waterSupply.dto.respond;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WaterMappingRespondDTO {
    private Long mappingId;
    private String sourceName;
    private String targetName;
}
