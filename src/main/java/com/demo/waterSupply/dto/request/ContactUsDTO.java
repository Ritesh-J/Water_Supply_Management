package com.demo.waterSupply.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactUsDTO {
    private String userName;
    private String userEmail;
    private String query;
}
