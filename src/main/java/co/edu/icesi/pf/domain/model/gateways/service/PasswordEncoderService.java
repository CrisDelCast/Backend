package co.edu.icesi.pf.domain.model.gateways.service;

public interface PasswordEncoderService {

    String encode(String password);

    boolean matches(String rawPassword, String encodedPassword);

}
