package construcao_software.ingresso_back.domain.entities;

import java.util.UUID;

import construcao_software.ingresso_back.domain.enums.TicketStatus;
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


    public TicketEntity(UserEntity seller, EventEntity event, Double originalPrice, TicketStatus available) {
        
        this.uniqueVerificationCode = UUID.randomUUID().toString();
        this.seller = seller;
        this.event = event;
        this.originalPrice = originalPrice;
        this.status = available;
    }
}
