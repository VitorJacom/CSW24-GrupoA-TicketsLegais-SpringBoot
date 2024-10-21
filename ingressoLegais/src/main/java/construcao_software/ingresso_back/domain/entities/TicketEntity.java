package construcao_software.ingresso_back.domain.entities;

import construcao_software.ingresso_back.domain.base.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketEntity {

    private Long ticketId;
    private EventEntity event;
    private TenantEntity tenant;
    private UserEntity seller;
    private Double originalPrice;
    private String uniqueVerificationCode;
    private TicketStatus status;
}
