package co.edu.icesi.pf.domain.usecase.auth;

import co.edu.icesi.pf.domain.model.enums.DomainErrorType;
import co.edu.icesi.pf.domain.model.exceptions.DomainException;
import co.edu.icesi.pf.domain.model.gateways.repository.UserRepository;
import co.edu.icesi.pf.domain.model.gateways.service.PasswordEncoderService;
import co.edu.icesi.pf.domain.model.gateways.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginUseCase {

    private final UserRepository userRepository;
    private final SecurityService securityService;
    private final PasswordEncoderService passwordEncoderService;

    public String login(String email, String poolId, String password) {
        var user = userRepository.findByEmailAndPoolId(email, poolId);
        var loggedIn = passwordEncoderService.matches(password, user.getPassword());
        if (!loggedIn) {
            throw new DomainException(DomainErrorType.INVALID_INPUT, "Invalid password");
        }
        return securityService.generateToken(user);
    }

}
