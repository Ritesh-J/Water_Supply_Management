package com.demo.waterSupply.dto.respond;

import com.demo.waterSupply.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.parsers.SAXParser;
import java.security.PrivilegedAction;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UtilityRespondDTO {
    private Long utilityId;
    private String utilityName;
}
