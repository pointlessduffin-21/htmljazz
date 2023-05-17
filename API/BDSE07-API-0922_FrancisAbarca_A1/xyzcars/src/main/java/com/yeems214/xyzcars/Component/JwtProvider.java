package com.yeems214.xyzcars.Component;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    @Value("$(jwt.secret)")
    private String jwtSecret;
}