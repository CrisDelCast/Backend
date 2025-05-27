package co.edu.icesi.pf.domain.usecase.auth;

import co.edu.icesi.pf.domain.model.entities.User;
import co.edu.icesi.pf.domain.model.gateways.repository.UserRepository;
import co.edu.icesi.pf.domain.model.gateways.service.PasswordEncoderService;
import co.edu.icesi.pf.domain.model.gateways.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegisterUseCase {

    private final UserRepository userRepository;
    private final SecurityService securityService;
    private final PasswordEncoderService passwordEncoderService;

    public String register(User user) {
        var encodedPassword = passwordEncoderService.encode(user.getPassword());
        user.setPassword(encodedPassword);
        var newUser = userRepository.findByEmailAndPoolId(user.getEmail(), user.getPool().getId());
        return securityService.generateToken(newUser);
    }

}
