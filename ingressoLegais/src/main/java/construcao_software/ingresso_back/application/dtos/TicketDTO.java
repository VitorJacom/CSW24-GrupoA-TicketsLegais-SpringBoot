package construcao_software.ingresso_back.application.dtos;

import construcao_software.ingresso_back.domain.base.TicketStatus;
import lombok.Data;

@Data
public class TicketDTO {

    private Long ticketId;
    private EventDTO event;
    private TenantDTO tenant;
    private Double originalPrice;
    private UserDTO seller;
    private String uniqueVerificationCode;
    private TicketStatus status;
}
