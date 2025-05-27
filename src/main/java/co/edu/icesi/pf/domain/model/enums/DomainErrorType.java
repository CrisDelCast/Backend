package co.edu.icesi.pf.domain.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DomainErrorType {

    NOT_FOUND(404, "Not Found: %s"),
    INVALID_INPUT(400, "Invalid Input: %s"),
    ALREADY_EXISTS(400, "Already Exists: %s"),;

    private final int code;
    private final String message;

}
