package co.edu.icesi.pf.infrastructure.drivenadapter.jwt;

import co.edu.icesi.pf.domain.model.entities.User;
import co.edu.icesi.pf.domain.model.gateways.service.SecurityService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class SecurityAdapter implements SecurityService {

    @Value("${adapter.jwt.secret}")
    private String secret;

    @Value("${adapter.jwt.expiration}")
    private Long expiration;

    @Override
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("pool", user.getPool().getId())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getKey(secret))
                .compact();
    }

    @Override
    public boolean validateToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey(secret))
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getExpiration().after(new Date());
    }

    @Override
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey(secret))
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    @Override
    public String getRoleFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey(secret))
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.get("role", String.class);
    }

    @Override
    public String getPoolFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey(secret))
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.get("pool", String.class);
    }

    private Key getKey(String s) {
        return Keys.hmacShaKeyFor(s.getBytes());
    }

}
