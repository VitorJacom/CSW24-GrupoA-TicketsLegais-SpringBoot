package construcao_software.ingresso_back.application.dtos;

public record ErrorDTO (
        String error_code,
        String error_description,
        String error_Message
) {
}
