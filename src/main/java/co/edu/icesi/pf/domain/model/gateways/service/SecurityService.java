package co.edu.icesi.pf.domain.model.gateways.service;

import co.edu.icesi.pf.domain.model.entities.User;

public interface SecurityService {

    String generateToken(User user);

    boolean validateToken(String token);

    String getUsernameFromToken(String token);

    String getRoleFromToken(String token);

    String getPoolFromToken(String token);

}
