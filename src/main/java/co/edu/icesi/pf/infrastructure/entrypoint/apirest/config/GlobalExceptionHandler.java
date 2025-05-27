package co.edu.icesi.pf.infrastructure.entrypoint.apirest.config;

import co.edu.icesi.pf.domain.model.exceptions.DomainException;
import co.edu.icesi.pf.infrastructure.entrypoint.apirest.dto.error.BasicErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<BasicErrorResponseDTO> handleDomainException(DomainException ex) {
        BasicErrorResponseDTO errorResponse = new BasicErrorResponseDTO(
                ex.getMessage(),
                "Domain Error",
                System.currentTimeMillis()
        );
        return ResponseEntity.status(ex.getErrorCode()).body(errorResponse);
    }

    @ExceptionHandler(MissingRequestValueException.class)
    public ResponseEntity<BasicErrorResponseDTO> handleMissingRequestValueException(MissingRequestValueException ex) {
        BasicErrorResponseDTO errorResponse = new BasicErrorResponseDTO(
                ex.getMessage(),
                "Bad Request",
                System.currentTimeMillis()
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BasicErrorResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = error instanceof FieldError fieldError ?
                    fieldError.getField() : error.getObjectName();
            String defaultMessage = error.getDefaultMessage();
            errors.add(fieldName + ": " + defaultMessage);
        });

        String errorMessage = String.join("; ", errors);

        BasicErrorResponseDTO errorResponse = new BasicErrorResponseDTO(
                errorMessage,
                "Validation Error",
                System.currentTimeMillis()
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BasicErrorResponseDTO> handleGenericException(Exception ex) {
        BasicErrorResponseDTO errorResponse = new BasicErrorResponseDTO(
                ex.getMessage(),
                "Internal Server Error",
                System.currentTimeMillis()
        );
        return ResponseEntity.status(500).body(errorResponse);
    }

}
