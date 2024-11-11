package construcao_software.ingresso_back.domain.entities;

import construcao_software.ingresso_back.domain.enums.TicketStatus;
import lombok.*;

@Data
public class TicketEntity {

    private Long ticketId;
    private EventEntity event;
    private TenantEntity tenant;
    private UserEntity seller;
    private Double originalPrice;
    private String uniqueVerificationCode;
    private TicketStatus status;
}
