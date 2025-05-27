package co.edu.icesi.pf.infrastructure.entrypoint.apirest.controller;

import co.edu.icesi.pf.domain.usecase.auth.LoginUseCase;
import co.edu.icesi.pf.infrastructure.entrypoint.apirest.dto.user.UserLoginDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginUseCase loginUseCase;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserLoginDTO credentials, @RequestHeader("Pool-Id") String poolId) {
        return ResponseEntity.ok(loginUseCase.login(credentials.email(), poolId, credentials.password()));
    }

}
