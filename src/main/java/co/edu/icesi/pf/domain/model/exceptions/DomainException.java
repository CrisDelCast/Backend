package co.edu.icesi.pf.domain.model.exceptions;

import co.edu.icesi.pf.domain.model.enums.DomainErrorType;
import lombok.Getter;

@Getter
public class DomainException extends RuntimeException {

    private final int errorCode;
    private final String message;

    protected DomainException(DomainErrorType errorType) {
        super(String.format(errorType.getMessage()));
        this.message = String.format(errorType.getMessage());
        this.errorCode = errorType.getCode();
    }

    public DomainException(DomainErrorType errorType, String... args) {
        super(String.format(errorType.getMessage(), args));
        this.message = String.format(errorType.getMessage(), args);
        this.errorCode = errorType.getCode();
    }

}
