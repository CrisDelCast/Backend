package co.edu.icesi.pf.infrastructure.drivenadapter.jwt;

import co.edu.icesi.pf.domain.model.gateways.service.SecurityService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationManager implements AuthenticationManager {

    private final SecurityService securityService;
    private final HttpServletRequest request;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = authentication.getCredentials().toString();
        String organizationHeader = request.getHeader("Pool-Id");

        if (!securityService.validateToken(token)) {
            throw new BadCredentialsException("Invalid token");
        }

        if (organizationHeader == null) {
            throw new BadCredentialsException("Missing Pool-Id header");
        }

        if (!organizationHeader.equals(securityService.getPoolFromToken(token))) {
            throw new BadCredentialsException("Pool-Id header mismatch");
        }

        String username = securityService.getUsernameFromToken(token);
        String role = securityService.getRoleFromToken(token);
        List<SimpleGrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority(role));

        return new UsernamePasswordAuthenticationToken(username, token, grantedAuthorities);
    }
}
