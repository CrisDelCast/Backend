package co.edu.icesi.pf.infrastructure.entrypoint.apirest.dto.error;

public record BasicErrorResponseDTO(
        String message,
        String error,
        long timestamp
) {
}
