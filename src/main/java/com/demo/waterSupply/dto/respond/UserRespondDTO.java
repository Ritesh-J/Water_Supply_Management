package com.demo.waterSupply.dto.respond;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRespondDTO {
    private String userName;
    private String roleName;
    private String cityName;
    private String meterName;

}
