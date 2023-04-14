package com.demo.waterSupply.dto.respond;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRespondDTO {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userAddress;
    private String roleName;
    private String cityName;
    private String meterName;

}
