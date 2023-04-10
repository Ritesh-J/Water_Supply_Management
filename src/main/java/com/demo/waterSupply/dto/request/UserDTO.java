package com.demo.waterSupply.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private int userId;
    private String userName;
    private String userEmail;
    private String userAddress;
    private String cityName;
    private String meterName;
    private String roleName;
}
