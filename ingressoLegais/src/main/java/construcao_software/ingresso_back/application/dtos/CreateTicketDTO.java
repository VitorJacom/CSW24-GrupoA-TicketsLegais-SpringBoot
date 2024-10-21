package construcao_software.ingresso_back.application.dtos;

public record CreateTicketDTO(
        Long eventId,
        Long sellerId,
        Double originalPrice
) {
}
