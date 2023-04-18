package com.demo.waterSupply.jwtUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {
    public static String getEmailFromJwt(String jwt) {
        DecodedJWT decodedJWT = JWT.decode(jwt);
        return decodedJWT.getClaim("email").asString();
    }
}
