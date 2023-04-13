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
    @NotBlank(message = "Enter A Valid User Id")
    private Long userId;
    @NotBlank(message = "Enter A Valid User Name")
    private String userName;
    @Email(message = "Enter a Valid Email")
    private String userEmail;
    @NotBlank(message = "Enter a Valid Address")
    private String userAddress;
    @NotBlank(message = "Enter a Valid Input")
    private String cityName;
    @NotBlank(message = "Enter a Valid Input")
    private String meterName;
    @NotBlank(message = "Enter a Valid Input")
    private String roleName;
}
