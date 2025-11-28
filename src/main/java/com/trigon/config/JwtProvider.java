package com.trigon.config;

import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
@Component
public class JwtProvider {

    // Remove this field!
    // SecretKey key=Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

    private SecretKey getSigningKey() {
        byte[] keyBytes = Base64.getDecoder().decode(JwtConstant.SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Authentication auth) {
        SecretKey key = getSigningKey();

        String jwt = Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 846_000_000))
                .claim("email", auth.getName())
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return jwt;
    }

    public String getMailFromToken(String jwt) {
        try {
        			  
			jwt = jwt.split(" ")[1].trim();
		 
            SecretKey key = getSigningKey();
            Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
            return String.valueOf(claims.get("email"));
        } catch (JwtException e) {
            throw new RuntimeException("Invalid JWT", e);
        }
    }
}

