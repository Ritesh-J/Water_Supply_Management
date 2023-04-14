package com.demo.waterSupply.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequestDTO {
    private String userName;
    private String userEmail;
    private String userAddress;
    private String cityName;
    private String meterName;
    private String roleName;
}
